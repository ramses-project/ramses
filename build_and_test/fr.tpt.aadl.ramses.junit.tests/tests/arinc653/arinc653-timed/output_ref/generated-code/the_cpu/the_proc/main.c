
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_arinc653_events_names[POK_CONFIG_NB_EVENTS] = {"the_proc_the_receiver_barrier"};
EVENT_ID_TYPE the_proc_the_receiver_barrier;
char* pok_buffers_names[POK_CONFIG_NB_BUFFERS] = {"the_receiver_p_in_globalVariable"};
BUFFER_ID_TYPE the_receiver_p_in_globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_EVENT ("the_proc_the_receiver_barrier",&the_proc_the_receiver_barrier,& (ret));
  CREATE_BUFFER ("the_receiver_p_in_globalVariable",    sizeof( common_pkg__Integer ), 10, FIFO,&the_receiver_p_in_globalVariable,& (ret));
  tattr.ENTRY_POINT = test_sporadic_refined_model__the_proc_the_sender_impl_Job;
  tattr.PERIOD = 2000;
  tattr.DEADLINE = 2000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 5;
  strcpy(tattr.NAME, "the_sender");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = test_sporadic_refined_model__the_proc_the_receiver_impl_Job;
  tattr.PERIOD = 1000;
  tattr.DEADLINE = 1000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 15;
  strcpy(tattr.NAME, "the_receiver");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  tattr.ENTRY_POINT = test_sporadic_refined_model__the_proc_the_periodic_impl_Job;
  tattr.PERIOD = 500;
  tattr.DEADLINE = 500;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 20;
  strcpy(tattr.NAME, "the_periodic");
  CREATE_PROCESS (&(tattr), &(arinc_threads[3]), &(ret));
  START (arinc_threads[3], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
/*                                SEND OUTPUT                                 */

void __aadl_send_output (unsigned int port_variable, void * value)
{
  RETURN_CODE_TYPE ret;
  SYSTEM_TIME_TYPE time_out;
  MESSAGE_SIZE_TYPE length;
  switch (port_variable) {
    if(value==NULL)
    {
      char i=0;
      value = &i;
    }
    case 0:
      time_out = 0;
      length = sizeof( common_pkg__Integer );
      SEND_BUFFER(the_receiver_p_in_globalVariable, value, length, time_out, &ret);
      break;
  }
}
