
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_buffers_names[POK_CONFIG_NB_BUFFERS] = {"the_receiver_p_in_globalVariable"};
BUFFER_ID_TYPE the_receiver_p_in_globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
test_sporadic_refined_model__the_proc_the_sender_impl_Init();
test_sporadic_refined_model__the_proc_the_receiver_impl_Init();
test_sporadic_refined_model__the_proc_the_periodic_impl_Init();
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
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
