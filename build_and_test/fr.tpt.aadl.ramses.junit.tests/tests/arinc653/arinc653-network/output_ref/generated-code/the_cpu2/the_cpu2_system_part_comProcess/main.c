
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
QUEUING_PORT_ID_TYPE the_cpu2_system_part_comProcess_the_proc2_p_in_globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_QUEUING_PORT ("the_cpu2_system_part_comProcess_the_proc2_p_in",
    sizeof( common_pkg__Integer ), 10, SOURCE, FIFO,
      &(the_cpu2_system_part_comProcess_the_proc2_p_in_globalVariable), &(ret));
  tattr.ENTRY_POINT = test_network_rtl8029_remote_communications_refined_model__the_cpu2_system_part_comProcess_system_part_comm_impl_Job;
  tattr.PERIOD = 1000;
  tattr.DEADLINE = 1000;
  tattr.BASE_PRIORITY = 5;
  strcpy(tattr.NAME, "system_part_comm");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = test_network_rtl8029_remote_communications_refined_model__the_cpu2_system_part_comProcess_the_cpu2_system_part_comm_impl_Job;
  tattr.PERIOD = 1000;
  tattr.DEADLINE = 1000;
  tattr.BASE_PRIORITY = 10;
  strcpy(tattr.NAME, "the_cpu2_system_part_comm");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
