#include "diplay.h"
#include "kernel.h"
#include "kernel_id.h"

#include "ecrobot_interface.h"

extern U8 colorPortNb;
extern U8 sensor_mode;

int value=0;

void displayColor(U16 color, int  line_start){
	display_goto_xy(0, 0+line_start);
	display_string("COLOR mode");
	display_goto_xy(0, 1+line_start);
	switch(color)
	{
		case NXT_COLOR_BLACK:
			display_string("BLACK::");display_int(color,0);
			break;
		case NXT_COLOR_BLUE:
			display_string("BLUE::");display_int(color,0);
			break;
		case NXT_COLOR_GREEN:
			display_string("GREEN::");display_int(color,0);
			break;
		case NXT_COLOR_YELLOW:
			display_string("YELLOW::");display_int(color,0);
			break;
		case NXT_COLOR_ORANGE:
			display_string("ORANGE::");display_int(color,0);
			break;
		case NXT_COLOR_RED:
			display_string("RED::");display_int(color,0);
			break;
		case NXT_COLOR_WHITE:
			display_string("WHITE::");display_int(color,0);
			break;
		default:
			display_string("UNK COL::");display_int(color,0);
			break;
	}
}
//
//void decide(__displaycolor_context ctx, U16 currentColor, U16 colorPath){
//
//	display_clear(0);
//	displayColor(currentColor,0);
//	displayColor(colorPath,2);
//	display_goto_xy(0, 5);
//
//	if (currentColor == colorPath){
//		__aadl_send_output(ctx.onpath, &value);
//		display_string("ONPATH");
//	}
//	if (currentColor != colorPath){
//		__aadl_send_output(ctx.lost,&value);
//		display_string("LOST");
//	}
//	display_update();
//	return;
//}

void decide (__displaycolor_context ctx,int currentColor,int colorPath)
//void decide (int currentColor,int colorPath)
//void decide (int currentColor)
{
	display_clear(0);
	displayColor(colorPath, 0);
	displayColor(currentColor, 2);

//	display_goto_xy(0, 4);display_int(ctx,0);

	display_goto_xy(0, 6);display_int(colorPath,0);
	display_goto_xy(0, 5);display_int(currentColor,0);

	__aadl_send_output(ctx.lost,&value);
	display_update();
}

void ecrobot_device_initialize(void)
{
	ecrobot_init_nxtcolorsensor(colorPortNb	, NXT_COLORSENSOR);
}

void ecrobot_device_terminate(void)
{
	ecrobot_term_nxtcolorsensor(colorPortNb);
}
