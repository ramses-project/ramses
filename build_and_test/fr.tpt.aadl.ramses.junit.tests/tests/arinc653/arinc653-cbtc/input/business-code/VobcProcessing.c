
#include "Tools.h"

#include "VobcProcessing.h"


#define MAX_ZONE 11
#define MAX_STN 5

static const double ONE_MILLE   =       1000.;
static const double ONE_MILLION =    1000000.;
static const double ONE_BILLION = 1000000000.;
  
static const double CONV_MBYSEC_TO_KMBYH = 3.6; // 3600./1000.
static const double CONV_H_TO_MSEC = 3600000.;

static const int32_t max_cycle = 10;

/***
const int32_t zonetab [MAX_ZONE] =
               {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
***/

static const int32_t zonetab [MAX_ZONE] =
               {0, 2, 5, 7, 10, 12, 15, 17, 20, 22, 25};
               
static const int32_t speedtab [MAX_ZONE] =
               {30, 50, 100, 100, 100, 80, 100, 100, 50, 30, 30}; // kmh

/***               
const int32_t stationtab [MAX_STN] =
               {0, 20, 50, 70, 100};
***/
               
static const int32_t stationtab [MAX_STN] =
               {0, 5, 12, 17, 25};

// static const double minimum_distance = 500; //m
static const double minimum_distance = 150;    //m
static const double emerg_distance = 10;       //m
static const double emerg_braking_coef = 2;    // m/sec2
static const double normal_braking_coef = 0.6; // m/sec2
static const double min_braking_coef = 0.1;    // m/sec2
static const double max_traction_coef = 1;     // m/sec2
static const double min_traction_coef = 0.1;   // m/sec2

static struct timespec prev_ts = {0, 0};

int cycle_nb = 0;

int32_t 
VobcProcessing_compute_traction_data (VobcTrainData_ptr vobc_train_data)
{
  cycle_nb++;
  int32_t ret = 0;
  
  // set emergency brake if eoa has been exceeded by train
  int32_t delta_dist = vobc_train_data->distance_m - vobc_train_data->limit_position;
  
  if ((vobc_train_data->direction == 0 && delta_dist >= 0) ||
      (vobc_train_data->direction == 1 && delta_dist <= 0))
  {
    syslog (LOG_USER | LOG_INFO, "VobcProcessing_compute_traction_data : set emergency braking"); 

    vobc_train_data->acceleration = (int32_t) (-emerg_braking_coef * 10.);
    vobc_train_data->stop_cycle = 0;
    
    vobc_train_data->prev_distance_m = vobc_train_data->distance_m;
    vobc_train_data->prev_distance_mm = vobc_train_data->distance_mm;
    
    return 0;
  }
  
  // find the zone according to the distance
  int32_t zone = get_currindex (zonetab, MAX_ZONE, vobc_train_data->distance_m / 1000);
  
  // find the speed limit according to the zone
  vobc_train_data->maxi_speed =  speedtab [zone];
  
  // find the distance of the next station
  int32_t next_station = get_nextindex (stationtab, MAX_STN, 
                                        vobc_train_data->distance_m, 
                                        vobc_train_data->direction);
                                        
  // next point to be stop, compare with max limit position
  int32_t next_stop = next_station;
  if (vobc_train_data->direction == 0)
  {
    if (next_stop > vobc_train_data->limit_position)
    {
      next_stop = vobc_train_data->limit_position;
    }
  }
  else
  {
    if (next_stop < vobc_train_data->limit_position)
    {
      next_stop = vobc_train_data->limit_position;
    }
  }
  
  //syslog (LOG_USER | LOG_INFO, "VobcProcessing_compute_traction_data : next stop : %d",
  //        next_stop); 
  
  // compute delta time between two cycles
  double delta_time_msec = 0.;
  
  // get clock time
  struct timespec ts;
  
  int status = clock_gettime(CLOCK_REALTIME, &ts);
  if (status != 0)
  {
    printf("VobcProcessing_compute_traction_data() clock_gettime fail");
    return -1;
  }
  
  // if first cycle
  // get current clock time for next computing
  if (prev_ts.tv_sec == 0)
  {
    prev_ts.tv_sec = ts.tv_sec;
    prev_ts.tv_nsec = ts.tv_nsec;
  }
   
  // else compute delta t msec
  else
  {
    long delta_time_sec = ts.tv_sec - prev_ts.tv_sec;
    delta_time_msec = (double) delta_time_sec * ONE_MILLE;
    
    
    long delta_nsec = ts.tv_nsec - prev_ts.tv_nsec;
    delta_time_msec = delta_time_msec + ((double)delta_nsec / ONE_MILLION);
    
    prev_ts.tv_sec = ts.tv_sec;
    prev_ts.tv_nsec = ts.tv_nsec;    
  }
  
  // compute the train speed  km/h
  double train_speed = 0.;   // m/sec
  if (delta_time_msec > 0.)
  {
    long delta_dist_m = vobc_train_data->distance_m - vobc_train_data->prev_distance_m; // m
    long delta_dist_mm = vobc_train_data->distance_mm - vobc_train_data->prev_distance_mm; // mm
    
    double delta_dist = (double) delta_dist_m * ONE_MILLE + (double) delta_dist_mm;
    
    train_speed = delta_dist / delta_time_msec; // m/sec
    
    // if reverse direction, set positive speed
    if (vobc_train_data->direction != 0)
    {
      train_speed = -train_speed;
    }
    
    //---- vobc_train_data->speed = (int32_t) (train_speed * CONV_MBYSEC_TO_KMBYH);
    
    vobc_train_data->prev_distance_m = vobc_train_data->distance_m;
    vobc_train_data->prev_distance_mm = vobc_train_data->distance_mm;
  }
  
  // syslog (LOG_USER | LOG_INFO, "VobcProcessing_compute_traction_data : train speed Km/h %d maxi speed %d",
  //         vobc_train_data->speed, vobc_train_data->maxi_speed); 
  
  // set train current and maxi speed
  double curr_speed = (double) (vobc_train_data->speed / CONV_MBYSEC_TO_KMBYH);       // m/sec
  double max_speed = (double) (vobc_train_data->maxi_speed / CONV_MBYSEC_TO_KMBYH);   // m/sec
     
  // set acceleration not authorized
  int accel_author = 0;
  
  // check if braking to apply in case of eoa limit
  // distance for braking
  double brake_dist;
  if (vobc_train_data->direction == 0)
  {
    brake_dist = (double) (vobc_train_data->limit_position - vobc_train_data->distance_m);
  }
  else
  {
    brake_dist = (double) (vobc_train_data->distance_m - vobc_train_data->limit_position);
  }
  
  // compute braking to apply = 1/2 V2 / (g * dist)
  double brake_power = 0.;
  
  // if distance is minimum brake has to be applied
  if (brake_dist < minimum_distance)
  {
    if (brake_dist <= emerg_distance)
    {
      brake_power = emerg_braking_coef;
    }
    else
    {
      // set braking in m/sec2
      brake_power = 0.5 * (curr_speed * curr_speed) / brake_dist;
     
      if (brake_power > emerg_braking_coef)
      {
        brake_power = emerg_braking_coef;
      }
    }
  
    // minimum braking
    if (brake_power <= min_braking_coef)
    {
      brake_power = min_braking_coef;
    }
  }
  else
  {
    // set acceleration authorized
    accel_author = 1;
  }
  
  syslog (LOG_USER | LOG_INFO, "VobcProcessing_compute_traction_data step1 : brake %f accel_author %d",
          brake_power, accel_author);
  
   
  // if acceleration authorized, check maxi speed
  if (accel_author == 1)
  {    
    int32_t delta_speed = vobc_train_data->speed - vobc_train_data->maxi_speed;
    
    // check authorized maxi speed
    if (delta_speed > 0)
    {
      // reduce train speed
      accel_author = 0;
            
      // set braking for a distance of 30m in m/sec2
      // braking = 1/2 * (V2*V2 - V1*V1) / d      V in m/sec and d in m
      brake_power = 0.5 * ((curr_speed * curr_speed) - (max_speed * max_speed)) / 30.;
     
      if (brake_power > normal_braking_coef)
      {
        brake_power = normal_braking_coef;
      }
      else if (brake_power > 0. && brake_power < min_braking_coef)
      {
        brake_power = min_braking_coef;
      }
    }
      
    else if (delta_speed > -1)
    {
      // no acceleration is authorized, do not change train speed
      accel_author = 0;
    }
  }
  
  
  // train can accelerate
  
  double traction_power = 0.;
  
  if (accel_author == 1)
  {
    // set traction for a distance of 30m in m/sec2
    // traction = 1/2 * (V2*V2 - V1*V1) / d      V in m/sec and d in m
    traction_power = 0.5 * ((max_speed * max_speed) - (curr_speed * curr_speed)) / 30.;
     
    if (traction_power > max_traction_coef)
    {
      traction_power = max_traction_coef;
    }
    else if (traction_power > 0. && traction_power < min_traction_coef)
    {
      traction_power = min_traction_coef;
    }
  }
 
  syslog (LOG_USER | LOG_INFO, "VobcProcessing_compute_traction_data step2 : brake %f traction %f accel_author %d",
          brake_power, traction_power, accel_author);
  
  double final_accel;
  
  // if braking
  if (brake_power > 0.)
  {
    // vobc_train_data->acceleration = (int32_t) (-brake_power * 10.);
    final_accel = -brake_power * 10.;
    
    // if train stops
    if (vobc_train_data->speed == 0)
    {
      vobc_train_data->stop_cycle = 0;
    }
  }
  // if train can accelerate
  else if (traction_power > 0.)
  {
    // if train is stopped wait stop cycles
    if (vobc_train_data->stop_cycle < max_cycle)
    {
      vobc_train_data->stop_cycle ++;
      
      // change direction if limit reaches
      if (vobc_train_data->direction == 0 && 
          vobc_train_data->distance_m >= zonetab [MAX_ZONE-1] * ONE_MILLE)
      {
        vobc_train_data->direction = 1;
      }
      
      else if (vobc_train_data->direction == 1 && 
          vobc_train_data->distance_m <= zonetab [0] * ONE_MILLE)
      {
        vobc_train_data->direction = 0;
      }
      
      final_accel = 0.;
    }
    else
    {
      // vobc_train_data->acceleration = (int32_t) (traction_power * 10.);
      final_accel = traction_power * 10.;
    }
  }
  // else no acceleration or braking
  else
  {
    // vobc_train_data->acceleration = 0;
    final_accel = 0.;
  }
  
  // filtering
  double current_accel = (double) vobc_train_data->acceleration;
  
  current_accel = current_accel + 0.2*(final_accel - current_accel);
  
  vobc_train_data->acceleration = (int32_t) current_accel;
  
  syslog (LOG_USER | LOG_INFO, "VobcProcessing_compute_traction_data : train acceleration %d stop cycle %d",
          vobc_train_data->acceleration, vobc_train_data->stop_cycle );
    
  return ret;
}

