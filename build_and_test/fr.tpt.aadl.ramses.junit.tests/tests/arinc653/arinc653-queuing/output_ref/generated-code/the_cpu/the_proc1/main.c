
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
QUEUING_PORT_ID_TYPE the_proc1_p_out_globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_QUEUING_PORT ("the_proc1_p_out",
    sizeof( common_pkg__Integer ), 5, SOURCE, FIFO,
      &(the_proc1_p_out_globalVariable), &(ret));
  tattr.ENTRY_POINT = test_queuing_refined_model__the_proc1_the_sender_impl_Job;
  tattr.PERIOD = 2000;
  tattr.DEADLINE = 2000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 5;
  strcpy(tattr.NAME, "the_sender");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
