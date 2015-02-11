#ifndef ROBOT_H
#define ROBOT_H

/*********************/
/* Ungenerated datas */
/*********************/

#include "nxt_motors.h"
#include "ecrobot_interface.h"
#include "main.h"

//typedef enum Robot_state
//{
//	FORWARD = 0,
//	BACKWARD = 1,
//	STOP = 2
//} Robot_state;

typedef enum move_order {
	STOP = 0,
	FORWARD = 1,
	BACKWARD = 2,
	LEFT = 3,
	RIGHT = 4,
	LLEFT = 5,
	RRIGHT = 6
} move_order;

/*************************/
/* End Ungenerated datas */
/*************************/

/* treshold distances, in centimeters */
#define MIN_DISTANCE			20
#define MAX_DISTANCE			30

/* light sensor characteristics */
#define MIN_LUMINOSITY			0
#define MAX_LUMINOSITY			100
#define	MIN_LUMINOSITY_TRESHOLD	45
#define MAX_LUMINOSITY_TRESHOLD	55

/* motor characteristics */
#define MAX_SPEED				100
/* wheels characteristics, in millimeters */
#define PERIMETER				200

//void computePID(int in_light, int *out_angle);
//void computeSpeed(int in_angle, int *out_speedLeft, int * out_speedRight, Robot_state * state);
//void selectState(int in_distance, Robot_state *state);
//void getSonarMove(int count, int* speed, int* brake);
//
//void computePath(void);

void move_robot(__move_context ctx, move_order order, int speed);

#endif
