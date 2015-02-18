#ifndef DISPLAY_H
#define DISPLAY_H
#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
#include "main.h"



void decide (__displaycolor_context ctx, int currentColor, int colorPath);
//void decide (int currentColor, int colorPath);
//void decide (int currentColor);

void ecrobot_device_initialize(void);
void ecrobot_device_terminate(void);

#endif
