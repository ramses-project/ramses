
/******************************************************************************/
/*                                 INCLUSION                                  */

#include "main.h"
#include "activity.h"

/******************************************************************************/
/*                              GLOBAL VARIABLES                              */

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];
char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {"Monitor_changeState_error_C1_globalVariable","Monitor_changeState_delayed_error_C2_globalVariable","IPingOrPong_Cping_ping_delayed_PongIn_globalVariable","IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable","IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable","IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable",};
BLACKBOARD_ID_TYPE Monitor_changeState_error_C1_globalVariable=0;
BLACKBOARD_ID_TYPE Monitor_changeState_delayed_error_C2_globalVariable=1;
BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_delayed_PongIn_globalVariable=2;
BLACKBOARD_ID_TYPE IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable=3;
BLACKBOARD_ID_TYPE IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable=4;
BLACKBOARD_ID_TYPE IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable=5;
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
PingPong_refined_model__S1_inst_Monitor_changeState_impl_Init();
PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_impl_Init();
PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_Init();
PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_impl_Init();
PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_Init();
  PROCESS_ATTRIBUTE_TYPE tattr;
  RETURN_CODE_TYPE ret;
  CREATE_BLACKBOARD ("Monitor_changeState_error_C1_globalVariable", sizeof (Exception), &(Monitor_changeState_error_C1_globalVariable), &(ret));
  CREATE_BLACKBOARD ("Monitor_changeState_delayed_error_C2_globalVariable", sizeof (Exception), &(Monitor_changeState_delayed_error_C2_globalVariable), &(ret));
  CREATE_BLACKBOARD ("IPingOrPong_Cping_ping_delayed_PongIn_globalVariable", sizeof (PingPongMessage), &(IPingOrPong_Cping_ping_delayed_PongIn_globalVariable), &(ret));
  CREATE_BLACKBOARD ("IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable", sizeof (ROLE), &(IPingOrPong_Cping_ping_mode_aadlKeywords_globalVariable), &(ret));
  CREATE_BLACKBOARD ("IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable", sizeof (ROLE), &(IPingOrPong_Cping_delayed_PongIn_mode_aadlKeywords_globalVariable), &(ret));
  CREATE_BLACKBOARD ("IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable", sizeof (ROLE), &(IPingOrPong_Cpong_pong_mode_aadlKeywords_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_Mon_mode_C2",
    sizeof( ROLE ), SOURCE, 10,
      &(S1_inst_Mon_mode_C2_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PingOut",
    sizeof( PingPong_refined_model__PingPongMessage_freshness_t_impl ), SOURCE, 10,
      &(S1_inst_C1_PingOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PongOut",
    sizeof( PingPongMessage ), SOURCE, 10,
      &(S1_inst_C1_PongOut_globalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PingIn",
    sizeof( PingPong_refined_model__PingPongMessage_freshness_t_impl ), DESTINATION, 10,
      &(S1_inst_C1_PingInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_C1_PongIn",
    sizeof( PingPongMessage ), DESTINATION, 10,
      &(S1_inst_C1_PongInglobalVariable), &(ret));
  CREATE_SAMPLING_PORT ("S1_inst_Mon_error_C2",
    sizeof( Exception ), DESTINATION, 10,
      &(S1_inst_Mon_error_C2globalVariable), &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S1_inst_Monitor_changeState_impl_Job;
  tattr.PERIOD = 30;
  tattr.DEADLINE = 30;
  tattr.BASE_PRIORITY = 2;
  strcpy(tattr.NAME, "Monitor_changeState");
  CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
  START (arinc_threads[1], &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S1_inst_Monitor_delayed_error_C2_impl_Job;
  tattr.PERIOD = 30;
  tattr.DEADLINE = 30;
  tattr.BASE_PRIORITY = 2;
  strcpy(tattr.NAME, "Monitor_delayed_error_C2");
  CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
  START (arinc_threads[2], &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S1_inst_IPingOrPong_Cping_ping_impl_Job;
  tattr.PERIOD = 40;
  tattr.DEADLINE = 40;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "IPingOrPong_Cping_ping");
  CREATE_PROCESS (&(tattr), &(arinc_threads[3]), &(ret));
  START (arinc_threads[3], &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S1_inst_IPingOrPong_Cping_delayed_PongIn_impl_Job;
  tattr.PERIOD = 40;
  tattr.DEADLINE = 40;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "IPingOrPong_Cping_delayed_PongIn");
  CREATE_PROCESS (&(tattr), &(arinc_threads[4]), &(ret));
  START (arinc_threads[4], &(ret));
  tattr.ENTRY_POINT = PingPong_refined_model__S1_inst_IPingOrPong_Cpong_pong_impl_Job;
  tattr.PERIOD = 40;
  tattr.DEADLINE = 40;
  tattr.BASE_PRIORITY = 3;
  strcpy(tattr.NAME, "IPingOrPong_Cpong_pong");
  CREATE_PROCESS (&(tattr), &(arinc_threads[5]), &(ret));
  START (arinc_threads[5], &(ret));
  SET_PARTITION_MODE (NORMAL, &(ret));
  return (0);
}

/******************************************************************************/
