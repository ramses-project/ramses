#include "main.h"
/*********** Tasks ***********/
/*** Task test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_impl ***/
extern void *test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_impl_Job(void);


TASK(the_sender)
{
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_sender_impl_Job();
}

/*** Task test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_impl ***/
extern void *test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_impl_Job(void);


TASK(the_receiver)
{
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_impl_Job();
}

/*** Task test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_impl ***/
extern void *test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_impl_Job(void);


TASK(the_receiver_m1)
{
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m1_impl_Job();
}

/*** Task test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_impl ***/
extern void *test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_impl_Job(void);


TASK(the_receiver_m2)
{
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_receiver_m2_impl_Job();
}

/*** Task test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_impl ***/
extern void *test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_impl_Job(void);


TASK(the_proc_modes_mode_m1)
{
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_impl_Job();
}

/*** Task test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_impl ***/
extern void *test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_impl_Job(void);


TASK(the_proc_modes_mode_m2)
{
  test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_impl_Job();
}

/*********** Data ***********/

extern thread_queue_t the_proc_modes_mode_m1_globalQueue;
extern thread_queue_t the_proc_modes_mode_m2_globalQueue;
void __aadl_send_output (unsigned int port_variable, void * value)
{
  StatusType ret;
  switch (port_variable) {
    case 0:
      ret = SendOutput_runtime(&the_proc_modes_mode_m1_globalQueue, 0, value);
      ret = SendOutput_runtime(&the_proc_modes_mode_m2_globalQueue, 0, value);
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
