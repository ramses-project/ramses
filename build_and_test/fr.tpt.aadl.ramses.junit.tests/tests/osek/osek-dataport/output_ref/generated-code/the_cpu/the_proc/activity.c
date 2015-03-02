#include "activity.h"
#include "main.h"

extern data_port_t the_receiver_p_globalVariable;
void* test_osek_dataports_refined_model__the_proc_the_sender_impl_Job()
{
  while (1) {
    test_osek_dataports_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_globalVariable);
  }
  return 0;
}
extern data_port_t the_receiver_p_globalVariable;
void* test_osek_dataports_refined_model__the_proc_the_receiver_impl_Job()
{
  while (1) {
    test_osek_dataports_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_globalVariable);
  }
  return 0;
}
