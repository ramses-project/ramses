#ifndef __GENERATED_MAIN_H__
#define __GENERATED_MAIN_H__

#include "kernel.h"
#include "kernel_id.h"
DeclareTask(the_sender);
DeclareTask(the_receiver);
DeclareTask(the_receiver_m1);
DeclareTask(the_receiver_m2);
DeclareTask(the_proc_modes_mode_m1);
DeclareTask(the_proc_modes_mode_m2);
DeclareResource(the_proc_modes_mode_m1_globalQueue_rez);
DeclareEvent(the_proc_modes_mode_m1_globalQueue_evt);
DeclareResource(the_proc_modes_mode_m2_globalQueue_rez);
DeclareEvent(the_proc_modes_mode_m2_globalQueue_evt);
DeclareResource(the_receiver_input_data_globalVariable_m1_rez);
DeclareResource(the_receiver_input_data_globalVariable_m2_rez);
DeclareResource(the_receiver_m1_input_data_globalVariable_rez);
DeclareResource(the_receiver_m2_input_data_globalVariable_rez);
void __aadl_send_output (unsigned int port_variable, void * value);
DeclareCounter(the_cpu_SystemCounter);
#include "gtypes.h"
#endif
