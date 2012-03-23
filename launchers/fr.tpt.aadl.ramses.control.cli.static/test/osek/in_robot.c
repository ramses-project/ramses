#include "in_robot.h"
#include <math.h>

/**
 * Calcule l'angle que le robot doit prendre pour suivre la route.
 */
void computePID(int in_light, int *out_angle)
{
	if(in_light < MIN_LUMINOSITY_TRESHOLD)
		*out_angle = (MAX_LUMINOSITY + MAX_LUMINOSITY) / 2 - in_light;
	else if(in_light > MAX_LUMINOSITY_TRESHOLD)
		*out_angle = -(in_light - (MAX_LUMINOSITY + MAX_LUMINOSITY) / 2);
	else
		*out_angle = 0;
}


/**
 * Calcule la vitesse a appliquer aux deux moteurs en fonction de la correction de trajectoire  appliquer.
 */
void computeSpeed(int in_angle, int *out_speedLeft, int * out_speedRight, Robot_state * state)
{
  switch(*state)
  {
    case STOP:
      *out_speedLeft = 0;
      *out_speedRight = 0;
      break;
    case FORWARD:
      *out_speedLeft = MAX_SPEED; 
      *out_speedRight = MAX_SPEED; 
      break;
    case BACKWARD:
      *out_speedLeft = -MAX_SPEED; 
      *out_speedRight = -MAX_SPEED;
      break;
  }
}


/* OK */
void selectState(int in_distance, Robot_state *state)
{
	if(in_distance < MIN_DISTANCE)
          *state = BACKWARD;
	else if(in_distance > MAX_DISTANCE)
          *state = FORWARD;
	else
          *state = STOP;
}


/*********************/
/* Ungenerated datas */
/*********************/

#include "tpl_os.h"

void StartupHook(void)
{
  ecrobot_init_sonar_sensor(NXT_PORT_S1);
  ecrobot_set_light_sensor_active(NXT_PORT_S2);
}

void ShutdownHook(StatusType error)
{
  ecrobot_term_sonar_sensor(NXT_PORT_S1);
  ecrobot_set_light_sensor_inactive(NXT_PORT_S2);
}

/*void nxt_use_case__PROC_C_Th_impl_Job(Robot_state *state)
{
    int light = ecrobot_get_light_sensor(NXT_PORT_S2);
  
    int out_speedLeft;
    int out_speedRight;

    int angle;

    computePID(light, &angle);

    computeSpeed(angle, &out_speedLeft, &out_speedRight, state);
	
    nxt_motor_set_speed(NXT_PORT_A, out_speedLeft, 0);
    nxt_motor_set_speed(NXT_PORT_C, out_speedRight, 0);

  TerminateTask();
}


void nxt_use_case__PROC_E_Th_impl_Job(Robot_state *state)
{
    int distance = ecrobot_get_sonar_sensor(NXT_PORT_S1);
    
    selectState(distance, state);
	
    TerminateTask();
}*/

/*************************/
/* End Ungenerated datas */
/*************************/
