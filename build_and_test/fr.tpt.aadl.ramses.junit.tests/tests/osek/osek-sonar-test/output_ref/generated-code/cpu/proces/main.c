#include "main.h"
/*********** Tasks ***********/
/*** Task sonarTest_refined_model__proces_th_impl ***/
extern void *sonarTest_refined_model__proces_th_impl_Job(void);


TASK(th)
{
  sonarTest_refined_model__proces_th_impl_Job();
}

/*********** Data ***********/

void __aadl_send_output (unsigned int port_variable, void * value)
{
  StatusType ret;
  switch (port_variable) {
  }
}
void StartupHook(void)
{
}

void ShutdownHook(StatusType ercd)
{
}


void user_1ms_isr_type2(void)
{
  StatusType ercd;
  ercd = SignalCounter(cpu_SystemCounter); /* Increment OSEK Alarm Counter */
  if(ercd != E_OK)
  {
    ShutdownOS(ercd);
    }
      }
