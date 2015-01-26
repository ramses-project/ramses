#include "show.h"
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"


void show(int distance)
{
	display_goto_xy(0, 0);
	display_string("DISTANCE :");
	display_goto_xy(0, 1);
	display_unsigned(distance,10);
	display_update();
}


void ecrobot_device_initialize(void)
{
	ecrobot_init_sonar_sensor(NXT_PORT_S4);
}

void ecrobot_device_terminate(void)
{
	ecrobot_term_sonar_sensor(NXT_PORT_S4);
}
