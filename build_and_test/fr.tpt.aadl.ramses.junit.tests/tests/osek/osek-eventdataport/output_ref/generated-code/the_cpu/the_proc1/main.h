#ifndef __GENERATED_MAIN_H__
#define __GENERATED_MAIN_H__

#include "kernel.h"
#include "kernel_id.h"
DeclareTask(the_sender);
DeclareTask(the_receiver);
DeclareResource(the_receiver_globalQueue_rez);
DeclareEvent(the_receiver_globalQueue_evt);
void __aadl_send_output (unsigned int port_variable, void * value);
DeclareCounter(the_cpu_SystemCounter);
#include "gtypes.h"
#endif
