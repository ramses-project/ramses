#include "in_robot.h"
#include <math.h>

/**
 * Computes the angle the robot has to turn in order to follow the road.
 */
#define KP 60 //60
#define KI 15 //10

int integral=0;
int lastColor = 1;

void computePID(int in_light, int colorToFollow, int *out_angle)
{
  char error;
  if(in_light == 99)
    error = 0;
  else if(in_light ==  colorToFollow)
    {
      error = 20;
      if(lastColor=1)
	integral=0;
      lastColor=0;
    }
  else
    {
      if(lastColor=0)
	integral=0;
      error = -20;
      lastColor=1;
    }
  integral = integral + error; //  multiply by period
  if(integral>90)
    integral = 90;
  if(integral<-120)
      integral=-120;
  *out_angle = (KP * error + KI*integral)/100;

  // memoire --> pour remettre à 0 l'intégral sur changement d'état.
}


/**
 * Compute the speed to apply on each engine to turn the robot in a given (relative) angle.
 */
void computeSpeed(int in_angle, int *out_speedLeft, int * out_speedRight, Robot_state * state)
{
  int speed = MAX_SPEED-30;
  switch(*state)
  {
    case STOP:
      *out_speedLeft = 0;
      *out_speedRight = 0;
      break;
    case FORWARD:
      *out_speedLeft = speed+in_angle; 
      *out_speedRight = speed-in_angle;
      /*      if(in_angle>0)
	{
	  *out_speedLeft = speed+in_angle; 
	  *out_speedRight = speed-in_angle; 
	}
      else if(in_angle<0)
	{
	  *out_speedLeft = speed+in_angle; 
	  *out_speedRight = speed-in_angle; 
	}
      else
	{
	  *out_speedLeft = speed; 
	  *out_speedRight = speed; 
	  }*/
      break;
    case BACKWARD:
      *out_speedLeft = -(MAX_SPEED+in_angle); 
      *out_speedRight = -(MAX_SPEED-in_angle);
      break;
  }
}


void selectState(int in_distance, Robot_state *state)
{
	if(in_distance < MIN_DISTANCE)
          *state = BACKWARD;
	else if(in_distance > MAX_DISTANCE)
          *state = FORWARD;
	else
          *state = STOP;
}

#define SONAR_SPEED 65
#define ROTATION 60
char direction=1;

void getSonarMove(int count, int* speed, int* brake)
{
  ecrobot_debug1(count, direction, *speed);
  if(direction==1)
  {
    if(count<ROTATION)
    {
      *brake=0;
      *speed = SONAR_SPEED;
    }
    else
    {
      *speed=0;
      *brake=1;
      direction = -1;
    }
  }
  else 
  {
    if(count > -ROTATION)
    {
	*brake=0;
        *speed=-SONAR_SPEED;
    }
    else
    {
	*speed = 0;
	*brake=1;
	direction = 1;
    }
  }
}

/*********************/
/* Ungenerated datas */
/*********************/

#include "kernel.h"

void ecrobot_device_initialize(void)
{
	ecrobot_init_nxtcolorsensor(NXT_PORT_S1, NXT_COLORSENSOR); // initialize a sensor
	ecrobot_init_sonar_sensor(NXT_PORT_S4);
	nxt_motor_set_count(NXT_PORT_B, 0);

}

void ecrobot_device_terminate(void)
{
	ecrobot_term_nxtcolorsensor(NXT_PORT_S1); // terminate a sensor
}

/*************************/
/* End Ungenerated datas */
/*************************/
