#include "activity.h"
#include "main.h"

extern BUFFER_ID_TYPE the_receiver_p_in_globalVariable;
void test_sporadic_refined_model__the_proc_the_sender_impl_Init()
{
}

void* test_sporadic_refined_model__the_proc_the_sender_impl_Job()
{
  while (1) {
    test_sporadic_refined_model__the_proc_the_sender_entrypoint_impl (&the_receiver_p_in_globalVariable);
  }
  return 0;
}
extern BUFFER_ID_TYPE the_receiver_p_in_globalVariable;
void test_sporadic_refined_model__the_proc_the_receiver_impl_Init()
{
}

void* test_sporadic_refined_model__the_proc_the_receiver_impl_Job()
{
  while (1) {
    test_sporadic_refined_model__the_proc_the_receiver_entrypoint_impl (&the_receiver_p_in_globalVariable);
  }
  return 0;
}
void test_sporadic_refined_model__the_proc_the_periodic_impl_Init()
{
}

void* test_sporadic_refined_model__the_proc_the_periodic_impl_Job()
{
  while (1) {
    test_sporadic_refined_model__the_proc_the_periodic_entrypoint_impl ();
  }
  return 0;
}
