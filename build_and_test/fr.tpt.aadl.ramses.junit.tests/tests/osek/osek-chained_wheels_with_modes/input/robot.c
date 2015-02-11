#include "robot.h"
#include <math.h>



int value=0;

void move_robot(__move_context ctx, move_order order, int speed){
	int brake = 100;
	extern int leftEnginePort;
	extern int rightEnginePort;

	display_clear(0);
	display_goto_xy(0,0);
	display_string("order : ");	display_int(order, 0);
	display_goto_xy(0,1);
	display_string("speed : ");	display_int(speed,0);
	display_goto_xy(0,2);
	switch (order) {
	case STOP :
		display_string("stop");
		nxt_motor_set_speed(leftEnginePort, 0, brake);
		nxt_motor_set_speed(rightEnginePort, 0, brake);
		break;
	case FORWARD :
		display_string("forward");
		nxt_motor_set_speed(leftEnginePort, speed, 0);
		nxt_motor_set_speed(rightEnginePort, speed, 0);
		break;
	case BACKWARD :
		display_string("backward");
		nxt_motor_set_speed(leftEnginePort, -speed, 0);
		nxt_motor_set_speed(rightEnginePort, -speed, 0);
		break;
	case LEFT :
		display_string("left");
		nxt_motor_set_speed(leftEnginePort, 0, brake);
		nxt_motor_set_speed(rightEnginePort, speed, 0);
		break;
	case RIGHT :
		display_string("right");
		nxt_motor_set_speed(leftEnginePort, 0, brake);
		nxt_motor_set_speed(rightEnginePort, speed, 0);
		break;
	case LLEFT :
		display_string("lleft");
		nxt_motor_set_speed(leftEnginePort, -speed, 0);
		nxt_motor_set_speed(rightEnginePort, speed, 0);
		break;
	case RRIGHT :
		display_string("rright");
		nxt_motor_set_speed(leftEnginePort, speed, 0);
		nxt_motor_set_speed(rightEnginePort, -speed, 0);
		break;
	default :
		display_string("default");
		nxt_motor_set_speed(leftEnginePort, 0, brake);
		nxt_motor_set_speed(rightEnginePort, 0, brake);
		break;
	}
	display_update();
	__aadl_send_output(ctx.done, &value);
}


/*********************/
/* Ungenerated datas */
/*********************/

#include "kernel.h"

void ecrobot_device_initialize(void)
{

}

void ecrobot_device_terminate(void)
{

}
