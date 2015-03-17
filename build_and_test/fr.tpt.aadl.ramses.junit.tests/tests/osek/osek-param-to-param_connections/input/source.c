#include "source.h"


void check_color_fnc(U16 current_color){

}

void compute_angle_fnc(U16 current_color){

}




void displayColor(U16 color){
	switch(color)
	{
		case NXT_COLOR_BLACK:
			display_string("BLACK::  ");display_int(color,0);
			break;
		case NXT_COLOR_BLUE:
			display_string("BLUE::   ");display_int(color,0);
			break;
		case NXT_COLOR_GREEN:
			display_string("GREEN::  ");display_int(color,0);
			break;
		case NXT_COLOR_YELLOW:
			display_string("YELLOW:: ");display_int(color,0);
			break;
		case NXT_COLOR_ORANGE:
			display_string("ORANGE:: ");display_int(color,0);
			break;
		case NXT_COLOR_RED:
			display_string("RED::    ");display_int(color,0);
			break;
		case NXT_COLOR_WHITE:
			display_string("WHITE::  ");display_int(color,0);
			break;
		default:
			display_string("UNK COL::");display_int(color,0);
			break;
	}
	display_string("   ");
}
