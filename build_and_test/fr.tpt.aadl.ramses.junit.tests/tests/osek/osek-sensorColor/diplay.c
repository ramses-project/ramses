#include "display.h"
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"


void myDisplay(int currentColor)
{
	display_goto_xy(0, 0);
	display_string("COLOR");
	display_goto_xy(0, 1);
	switch(currentColor)
	{
		case NXT_COLOR_BLACK:
			display_string("BLACK");
			break;
		case NXT_COLOR_BLUE:
			display_string("BLUE");
			break;
		case NXT_COLOR_GREEN:
			display_string("GREEN");
			break;
		case NXT_COLOR_YELLOW:
			display_string("YELLOW");
			break;
		case NXT_COLOR_ORANGE:
			display_string("ORANGE");
			break;
		case NXT_COLOR_RED:
			display_string("RED");
			break;
		case NXT_COLOR_WHITE:
			display_string("WHITE");
			break;
		default:
			display_string("UNKNOWN COLOR");
			break;
	}
	display_update();
}


void ecrobot_device_initialize(void)
{
	ecrobot_init_nxtcolorsensor(NXT_PORT_S2	, NXT_COLORSENSOR);
}

void ecrobot_device_terminate(void)
{
	ecrobot_term_nxtcolorsensor(NXT_PORT_S2); // terminate a sensor
}
