/*---------- Includes  ----------------------------------------------*/
#include "cbtc_cbtc_subsystem_Implementations_TrainSimu_impl.h"
#include "cbtc_gui.h"

static const double ONE_MILLE   =       1000.;
static const double ONE_MILLION =    1000000.;
//static const double ONE_BILLION = 1000000000.;

static const double CONV_MBYSEC_TO_KMBYH = 3.6; // 3600./1000.
static const double CONV_H_TO_MSEC = 3600000.;

static const double MAX_TRAIN_SPEED = 100.;

static struct timespec m_prev_ts;

static uint32_t m_direction;      // 0 or 1
static double   m_speed;          // kmh
static double   m_acceleration;   // dm/sec2
static double   m_distance;       // m
static double   m_accel_indic;

////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSimu_trainSimulation


/*@
  @ requires \separated(delayed_trainDataIn,trainDataOut);
  @ requires \valid(delayed_trainDataIn);
  @ requires \valid(trainDataOut);

  @ assigns (*trainDataOut);

@*/

extern int cycle_nb;

void  TrainSimu_trainSimulation(TrainData* delayed_trainDataIn,TrainData* trainDataOut){
// Start of user code TrainSimu_trainSimulation

  int status;
  struct timespec ts;

  /* Start of user code for TrainSimu_DefaultMode_trainSimulation body */
  //printf("TrainSimu_DefaultMode_trainSimulation\n");

  syslog (LOG_USER | LOG_INFO,
          "TrainSim received from TrainPpu: "
          " message cycle = %d, "
          " ppu element = %d, "
          " speed = %d, "
          " acceleration dm/sec2 = %d, "
          " distance_m = %d, "
          " distance_mm = %d, "
          " eoa m = %d\n",
          (int)delayed_trainDataIn->msg_cycle,
          (int)delayed_trainDataIn->computing_element,
          (int)delayed_trainDataIn->speed,
          (int)delayed_trainDataIn->acceleration,
          (int)delayed_trainDataIn->distance_m,
          (int)delayed_trainDataIn->distance_mm,
          (int)delayed_trainDataIn->limit_position);

  // commands for train : acceleration and direction

  // get clock time
  status = clock_gettime(CLOCK_REALTIME, &ts);
  if (status != 0)
  {
    printf( "##> Error: clock_gettime fail" );
    return;
  }

  // if first cycle
  // get current clock time for next computing
  if (m_prev_ts.tv_sec == 0)
  {
    if( ts.tv_sec == 0 )
      {
        printf( "##> Error: ts.tv_sec is null !!!" );
      }
    m_prev_ts.tv_sec = ts.tv_sec;
    m_prev_ts.tv_nsec = ts.tv_nsec;
  }

  // else compute delta t msec
  else
  {
    long delta_time_sec = ts.tv_sec - m_prev_ts.tv_sec;
    double delta_time_msec = (double) delta_time_sec * ONE_MILLE;

    long delta_nsec = ts.tv_nsec - m_prev_ts.tv_nsec;
    delta_time_msec = delta_time_msec + ((double)(delta_nsec) / ONE_MILLION);

    m_prev_ts.tv_sec = ts.tv_sec;
    m_prev_ts.tv_nsec = ts.tv_nsec;

    m_direction = delayed_trainDataIn->direction;

    // acceleration is received in dm/sec2 - convert in m/sec2
    m_acceleration = (double) (delayed_trainDataIn->acceleration) / 10.;

#ifdef USE_CBTC_GUI
    bool train_started = cbtc_gui.has_train_started();
#else
    bool train_started = true;
#endif

    // if train stopped or braking and speed is 0
    if ((train_started == false) || ((m_speed < 0.1) && (m_acceleration < 0.)))
    {
      m_acceleration = 0.;
    }

    // delta speed in m/sec
    double delta_speed = m_acceleration * (delta_time_msec/ONE_MILLE);

    // compute speed km/h
    m_speed = m_speed + (delta_speed * CONV_MBYSEC_TO_KMBYH);
    if (m_speed <= 0.)
    {
      m_speed = 0.;
      m_acceleration = 0.;
    }
    else if (m_speed > MAX_TRAIN_SPEED)
    {
      m_speed = MAX_TRAIN_SPEED;
      m_acceleration = 0.;
    }

    // compute distance m, speed in km/h
    double delta_dist = (m_speed * ONE_MILLE * delta_time_msec) / CONV_H_TO_MSEC;

    if (m_direction == 0)
    {
      m_distance = m_distance + delta_dist;
    }
    else
    {
      m_distance = m_distance - delta_dist;
    }

    // filter indicated acceleration
    m_accel_indic = m_accel_indic + 0.65 * (m_acceleration - m_accel_indic);
    int accel = (int)(m_accel_indic * 10);
    
    if (accel < 0)
    {
      accel = -accel;
    }
    if(cycle_nb<10)
    {
      printf("TRAIN SPEED = %d\n", (int)m_speed);
      printf("TRAIN MAXI SPEED = %d\n", (int)delayed_trainDataIn->maxi_speed);
      printf("TRAIN POSITION = %d\n", (int)m_distance);  // m
      printf("TRAIN EOA = %d\n", (int)delayed_trainDataIn->limit_position);  // m

      if (m_acceleration >= 0)
      {
        printf("TRAIN ACCEL = %d\n", accel);
        printf("TRAIN BRAKE = 0\n");
      }
      else
      {
        printf("TRAIN ACCEL = 0\n");
        printf("TRAIN BRAKE = %d\n", accel);
      }
    }
    
#ifdef USE_CBTC_GUI
    //MCCM_LOG("CBTC GUI SET SPEED");
    cbtc_gui.set_speed ((int)m_speed);
    cbtc_gui.set_maxi_speed ((int)delayed_trainDataIn->maxi_speed);
    cbtc_gui.set_distance ((int)m_distance);  // m
    cbtc_gui.set_end_of_author ((int)delayed_trainDataIn->limit_position);  // m

    if (m_acceleration >= 0)
    {
      cbtc_gui.set_acceleration (accel);
      cbtc_gui.set_braking (0);
    }
    else
    {
      cbtc_gui.set_acceleration (0);
      cbtc_gui.set_braking (accel);
    }
#endif
  }

  {
    double dist_1 = (double) m_distance;
    double dist_2 = m_distance - dist_1;
    trainDataOut->source_ident       =  delayed_trainDataIn->source_ident;
    trainDataOut->destination_ident  =  delayed_trainDataIn->destination_ident;
    trainDataOut->computing_element  =  delayed_trainDataIn->computing_element;
    trainDataOut->msg_cycle          =  delayed_trainDataIn->msg_cycle;
    trainDataOut->direction          =  m_direction;
    trainDataOut->acceleration       =  m_acceleration * 10;
    trainDataOut->limit_position     =  delayed_trainDataIn->limit_position;
    trainDataOut->maxi_speed         =  delayed_trainDataIn->maxi_speed;
    trainDataOut->speed              =  (int32_t) m_speed;
    trainDataOut->distance_m         =  (int32_t) m_distance;
    trainDataOut->distance_mm        =  (int32_t) dist_2;
    trainDataOut->sim_ctrl_1         =  delayed_trainDataIn->sim_ctrl_1;
    trainDataOut->sim_ctrl_2         =  delayed_trainDataIn->sim_ctrl_2;
    trainDataOut->sim_ctrl_3         =  delayed_trainDataIn->sim_ctrl_3;
    trainDataOut->sim_ctrl_4         =  delayed_trainDataIn->sim_ctrl_4;
  }

  syslog (LOG_USER | LOG_INFO,
          "TrainSim send to TrainPpu      : "
          " message cycle = %d, "
          " ppu element = %d, "
          " speed = %d, "
          " acceleration dm/sec2 = %d, "
          " distance_m = %d, "
          " distance_mm = %d, "
          " eoa m = %d\n",
          (int)trainDataOut->msg_cycle,
          (int)trainDataOut->computing_element,
          (int)trainDataOut->speed,
          (int)trainDataOut->acceleration,
          (int)trainDataOut->distance_m,
          (int)trainDataOut->distance_mm,
          (int)trainDataOut->limit_position);

// End of user code

}







////////////////////////////////////////////////////////////////////////////////////////////
//Operation : TrainSimu_trainSimulation_init







void  TrainSimu_trainSimulation_init(){
// Start of user code TrainSimu_trainSimulation_init

  //printf("TrainSimu_DefaultMode_trainSimulation_init()\n");

  m_prev_ts.tv_sec = 0;
  m_prev_ts.tv_nsec = 0;

  m_direction = 0;
  m_speed = 0.;
  m_acceleration = 0.;
  m_distance = 0.;
  m_accel_indic = 0.;

#ifdef USE_CBTC_GUI
  cbtc_gui_launch(0, NULL);
#endif
 
// End of user code

}



