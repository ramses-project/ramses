
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  tattr.ENTRY_POINT = test_buffer_delayed_refined_model__the_proc_the_sender_impl_Job;
  tattr.PERIOD = 2000;
  tattr.DEADLINE = 2000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 5;
  strcpy(tattr.NAME, "the_sender");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = test_buffer_delayed_refined_model__the_proc_the_receiver_impl_Job;
  tattr.PERIOD = 1000;
  tattr.DEADLINE = 1000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 10;
  strcpy(tattr.NAME, "the_receiver");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
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
  if(value==NULL)
  {
    char i=0;
    value = &i;
  }
  switch (port_variable) {
    case 0:
      break;
  }
}
