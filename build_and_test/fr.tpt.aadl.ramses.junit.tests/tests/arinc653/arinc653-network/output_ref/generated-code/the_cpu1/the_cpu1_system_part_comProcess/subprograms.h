#ifndef __GENERATED_SUBPROGRAMS_H__
#define __GENERATED_SUBPROGRAMS_H__
#include "libpok/drivers/rtl8029.h"
#include "types.h"
#include "arinc653/queueing.h"
#include "middleware/port.h"
#include "arinc653/time.h"
#include "arinc653/types.h"
#include "gtypes.h"
#include "main.h"
void test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_system_part_comm_entrypoint_impl(
	Base_Types__Unsigned_32 *  the_proc1_p_out_comConnectionLength_len,
	pok_port_id_t *  the_proc1_p_out_comConnectionPortId_port_id,
	APEX_INTEGER *  p_out);

typedef enum {
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_system_part_comm_entrypoint_impl_BA_entrypoint_init_state,
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_system_part_comm_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_system_part_comm_entrypoint_impl_BA_entrypoint_exec_state,
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_system_part_comm_entrypoint_impl_BA_entrypoint_final_state
} test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_system_part_comm_entrypoint_impl_BA_State_t;

void test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_the_cpu1_system_part_comm_entrypoint_impl();

typedef enum {
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_the_cpu1_system_part_comm_entrypoint_impl_BA_entrypoint_init_state,
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_the_cpu1_system_part_comm_entrypoint_impl_BA_entrypoint_wait_dispatch_state,
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_the_cpu1_system_part_comm_entrypoint_impl_BA_entrypoint_exec_state,
  test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_the_cpu1_system_part_comm_entrypoint_impl_BA_entrypoint_final_state
} test_network_rtl8029_remote_communications_refined_model__the_cpu1_system_part_comProcess_the_cpu1_system_part_comm_entrypoint_impl_BA_State_t;


#endif

