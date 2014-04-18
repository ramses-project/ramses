
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {"the_receiver_p_in_globalVariable",};
BLACKBOARD_ID_TYPE the_receiver_p_in_globalVariable=0;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
test_blackboard_refined_model__the_proc_the_sender_impl_Init();
test_blackboard_refined_model__the_proc_the_receiver_impl_Init();
test_blackboard_refined_model__the_proc_error_handler_th_impl_Init();
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_BLACKBOARD ("the_receiver_p_in_globalVariable", sizeof (common_pkg__Integer), &(the_receiver_p_in_globalVariable), &(ret));
  tattr.ENTRY_POINT = test_blackboard_refined_model__the_proc_the_sender_impl_Job;
  tattr.PERIOD = 2000;
  tattr.DEADLINE = 2000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 5;
  strcpy(tattr.NAME, "the_sender");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = test_blackboard_refined_model__the_proc_the_receiver_impl_Job;
  tattr.PERIOD = 1000;
  tattr.DEADLINE = 1000;
  tattr.TIME_CAPACITY = 1;
  tattr.BASE_PRIORITY = 10;
  strcpy(tattr.NAME, "the_receiver");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  tattr.ENTRY_POINT = test_blackboard_refined_model__the_proc_error_handler_th_impl_Job;
  CREATE_ERROR_HANDLER (tattr.ENTRY_POINT,8192,&(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
