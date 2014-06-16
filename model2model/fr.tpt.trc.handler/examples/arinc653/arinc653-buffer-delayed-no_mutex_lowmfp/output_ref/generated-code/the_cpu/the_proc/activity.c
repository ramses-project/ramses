#include "activity.h"
#include "main.h"

extern test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl the_receiver_p_in_globalVariable;
extern periodic_delayed_context_t context_the_receiver_p_in;
void test_buffer_delayed_refined_model__the_proc_the_sender_impl_Init()
{
}

void* test_buffer_delayed_refined_model__the_proc_the_sender_impl_Job()
{
  while (1) {
    test_buffer_delayed_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_in_globalVariable, &context_the_receiver_p_in);
  }
  return 0;
}
extern test_buffer_delayed_refined_model__bufferArrayImpl_the_receiver_p_in_impl the_receiver_p_in_globalVariable;
extern periodic_delayed_context_t context_the_receiver_p_in;
void test_buffer_delayed_refined_model__the_proc_the_receiver_impl_Init()
{
}

void* test_buffer_delayed_refined_model__the_proc_the_receiver_impl_Job()
{
  while (1) {
    test_buffer_delayed_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_in_globalVariable, &context_the_receiver_p_in);
  }
  return 0;
}
