
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
SAMPLING_PORT_ID_TYPE S2_inst_C2_modeglobalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PingInglobalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PongInglobalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PingOut_globalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_PongOut_globalVariable;
SAMPLING_PORT_ID_TYPE S2_inst_C2_badSequenceNumber_globalVariable;

/******************************************************************************/
/*                                    MAIN                                    */

int main ()
{
PingPong_refined_model__S2_inst_a2_inst_impl_Init();
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_SAMPLING_PORT ("S2_inst_C2_mode",
    sizeof( ROLE ), DESTINATION, 10000,
      &(S2_inst_C2_modeglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PingIn",
    sizeof( PingPongMessage ), DESTINATION, 10000,
      &(S2_inst_C2_PingInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PongIn",
    sizeof( PingPongMessage ), DESTINATION, 10000,
      &(S2_inst_C2_PongInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PingOut",
    sizeof( PingPongMessage ), SOURCE, 10,
      &(S2_inst_C2_PingOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PongOut",
    sizeof( PingPongMessage ), SOURCE, 10,
      &(S2_inst_C2_PongOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_badSequenceNumber",
    sizeof( PingPong__Exception ), SOURCE, 10,
      &(S2_inst_C2_badSequenceNumber_globalVariable), &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S2_inst_a2_inst_impl_Job;
  tattr.PERIOD = 2000;
  tattr.DEADLINE = 2000;
  tattr.BASE_PRIORITY = 2;
  strcpy(tattr.NAME, "a2_inst");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
