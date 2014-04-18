
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
SAMPLING_PORT_ID_TYPE S1_inst_Mon_mode_C2_globalVariable;
SAMPLING_PORT_ID_TYPE S1_inst_C1_PingOut_globalVariable;
SAMPLING_PORT_ID_TYPE S1_inst_C1_PongOut_globalVariable;
SAMPLING_PORT_ID_TYPE S1_inst_C1_PingInglobalVariable;
SAMPLING_PORT_ID_TYPE S1_inst_C1_PongInglobalVariable;
SAMPLING_PORT_ID_TYPE S1_inst_Mon_error_C2globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
PingPong_refined_model__S1_inst_a1_inst_impl_Init();
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_SAMPLING_PORT ("S1_inst_Mon_mode_C2",
    sizeof( ROLE ), SOURCE, 10,
      &(S1_inst_Mon_mode_C2_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PingOut",
    sizeof( PingPongMessage ), SOURCE, 10,
      &(S1_inst_C1_PingOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PongOut",
    sizeof( PingPongMessage ), SOURCE, 10,
      &(S1_inst_C1_PongOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PingIn",
    sizeof( PingPongMessage ), DESTINATION, 10000,
      &(S1_inst_C1_PingInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PongIn",
    sizeof( PingPongMessage ), DESTINATION, 10000,
      &(S1_inst_C1_PongInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_Mon_error_C2",
    sizeof( PingPong__Exception ), DESTINATION, 10000,
      &(S1_inst_Mon_error_C2globalVariable), &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S1_inst_a1_inst_impl_Job;
  tattr.PERIOD = 2000;
  tattr.DEADLINE = 2000;
  tattr.BASE_PRIORITY = 1;
  strcpy(tattr.NAME, "a1_inst");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
