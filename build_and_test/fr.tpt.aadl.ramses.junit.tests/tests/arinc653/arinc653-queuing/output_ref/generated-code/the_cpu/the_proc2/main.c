
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
QUEUING_PORT_ID_TYPE the_proc2_p_inglobalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_QUEUING_PORT ("the_proc2_p_in",
    sizeof( common_pkg__Integer ), 10, DESTINATION, FIFO,
      &(the_proc2_p_inglobalVariable), &(ret));
  tattr.ENTRY_POINT = test_queuing_refined_model__the_proc2_the_receiver_impl_Job;
  tattr.PERIOD = 1000;
  tattr.DEADLINE = 1000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 10;
  strcpy(tattr.NAME, "the_receiver");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
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
  }
}
