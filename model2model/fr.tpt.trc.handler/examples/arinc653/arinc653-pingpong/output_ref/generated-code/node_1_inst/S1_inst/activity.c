#include "activity.h"
#include "main.h"

extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PingInglobalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PongInglobalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_Mon_error_C2globalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_Mon_mode_C2_globalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PingOut_globalVariable;
extern SAMPLING_PORT_ID_TYPE S1_inst_C1_PongOut_globalVariable;
void PingPong_refined_model__S1_inst_a1_inst_impl_Init()
{
}

void* PingPong_refined_model__S1_inst_a1_inst_impl_Job()
{
  TYPE PingPong_refined_model__S1_inst_a1_inst_impl_state_baKeywords;
  SEQ PingPong_refined_model__S1_inst_a1_inst_impl_seqNb = 0;
  while (1) {
    PingPong_refined_model__S1_inst_a1_inst_entrypoint_impl (&S1_inst_C1_PingInglobalVariable, &S1_inst_C1_PongInglobalVariable, &S1_inst_Mon_error_C2globalVariable, &S1_inst_Mon_mode_C2_globalVariable, &S1_inst_C1_PingOut_globalVariable, &S1_inst_C1_PongOut_globalVariable, &PingPong_refined_model__S1_inst_a1_inst_impl_state_baKeywords, &PingPong_refined_model__S1_inst_a1_inst_impl_seqNb);
  }
  return 0;
}
