#include "main.h"
/*********** Tasks ***********/
/*** Task test_osek_dataports_refined_model__the_proc_the_sender_impl ***/
extern void *test_osek_dataports_refined_model__the_proc_the_sender_impl_Job(void);


TASK(the_sender)
{
  test_osek_dataports_refined_model__the_proc_the_sender_impl_Job();
}

/*** Task test_osek_dataports_refined_model__the_proc_the_receiver_impl ***/
extern void *test_osek_dataports_refined_model__the_proc_the_receiver_impl_Job(void);


TASK(the_receiver)
{
  test_osek_dataports_refined_model__the_proc_the_receiver_impl_Job();
}

/*********** Data ***********/

void __aadl_send_output (unsigned int port_variable, void * value)
{
  StatusType ret;
  switch (port_variable) {
    case 0:
      break;
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
  ercd = SignalCounter(the_cpu_SystemCounter); /* Increment OSEK Alarm Counter */
  if(ercd != E_OK)
  {
    ShutdownOS(ercd);
    }
      }
