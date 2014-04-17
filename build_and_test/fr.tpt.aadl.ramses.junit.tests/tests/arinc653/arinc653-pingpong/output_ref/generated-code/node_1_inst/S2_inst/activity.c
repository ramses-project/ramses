#include "activity.h"
#include "main.h"

extern SAMPLING_PORT_ID_TYPE S2_inst_C2_modeglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PingInglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PongInglobalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PingOut_globalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_PongOut_globalVariable;
extern SAMPLING_PORT_ID_TYPE S2_inst_C2_badSequenceNumber_globalVariable;
void PingPong_refined_model__S2_inst_a2_inst_impl_Init()
{
}

void* PingPong_refined_model__S2_inst_a2_inst_impl_Job()
{
  SEQ PingPong_refined_model__S2_inst_a2_inst_impl_seqNb = 0;
  while (1) {
    PingPong_refined_model__S2_inst_a2_inst_entrypoint_impl (&S2_inst_C2_modeglobalVariable, &S2_inst_C2_PingInglobalVariable, &S2_inst_C2_PongInglobalVariable, &S2_inst_C2_PingOut_globalVariable, &S2_inst_C2_PongOut_globalVariable, &S2_inst_C2_badSequenceNumber_globalVariable, &PingPong_refined_model__S2_inst_a2_inst_impl_seqNb);
  }
  return 0;
}
