
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {"IPingOrPong_Cping_ping_delayed_PongIn_globalVariable",};
BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable=0;
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
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_BLACKBOARD ("IPingOrPong_Cping_ping_delayed_PongIn_globalVariable", sizeof (PingPongMessage), &(IPingOrPong_Cping_ping_delayed_PongIn_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_mode",
    sizeof( ROLE ), DESTINATION, 10,
      &(S2_inst_C2_modeglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PingIn",
    sizeof( PingPong_refined_model__PingPongMessage_freshness_t_impl ), DESTINATION, 10,
      &(S2_inst_C2_PingInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PongIn",
    sizeof( PingPongMessage ), DESTINATION, 10,
      &(S2_inst_C2_PongInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PingOut",
    sizeof( PingPong_refined_model__PingPongMessage_freshness_t_impl ), SOURCE, 10,
      &(S2_inst_C2_PingOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_PongOut",
    sizeof( PingPongMessage ), SOURCE, 10,
      &(S2_inst_C2_PongOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S2_inst_C2_badSequenceNumber",
    sizeof( Exception ), SOURCE, 10,
      &(S2_inst_C2_badSequenceNumber_globalVariable), &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S2_inst_IPingOrPong_Cping_ping_impl_Job;
  tattr.PERIOD = 40;
  tattr.DEADLINE = 40;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "IPingOrPong_Cping_ping");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S2_inst_IPingOrPong_Cping_delayed_PongIn_impl_Job;
  tattr.PERIOD = 40;
  tattr.DEADLINE = 40;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "IPingOrPong_Cping_delayed_PongIn");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S2_inst_IPingOrPong_Cpong_pong_impl_Job;
  tattr.PERIOD = 40;
  tattr.DEADLINE = 40;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "IPingOrPong_Cpong_pong");
  CREATE_PROCESS (&(tattr), &(arinc_threads[3]), &(ret));
  START (arinc_threads[3], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
