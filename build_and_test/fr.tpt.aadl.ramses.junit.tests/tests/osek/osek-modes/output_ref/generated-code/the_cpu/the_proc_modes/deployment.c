#include "deployment.h"
test_osek_modes__Integer c11 = 11;
test_osek_modes__Integer c22 = 22;
test_osek_modes__Integer the_receiver_input_data_m1_value;
test_osek_modes__Integer the_receiver_input_data_m2_value;
test_osek_modes__Integer the_receiver_m1_input_data_value;
test_osek_modes__Integer the_receiver_m2_input_data_value;
test_osek_modes_modes_refined_refined_model__the_proc_modes_mode_m1_p_bufferType the_proc_modes_mode_m1_p_value;
port_queue_t the_proc_modes_mode_m1_p_globalVariable = {2, 0, 0, 0, sizeof(Base_Types__Integer_16), the_proc_modes_mode_m1_p_value, 0};
test_osek_modes_modes_refined_refined_model__the_proc_modes_mode_m2_p_bufferType the_proc_modes_mode_m2_p_value;
port_queue_t the_proc_modes_mode_m2_p_globalVariable = {2, 0, 0, 0, sizeof(Base_Types__Integer_16), the_proc_modes_mode_m2_p_value, 0};
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_currentState the_proc_modes_mode_m2Parent_BA_currentState = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m2_currentState_ModeSwitch_init_state;
data_port_t the_receiver_m2_input_data_globalVariable = {&the_receiver_m2_input_data_globalVariable_rez, &c22, sizeof(test_osek_modes__Integer)};
thread_queue_t the_proc_modes_mode_m1_globalQueue = {&the_proc_modes_mode_m1_globalQueue_rez, &the_proc_modes_mode_m1, &the_proc_modes_mode_m1_globalQueue_evt, 0, 0, {&the_proc_modes_mode_m1_p_globalVariable}};
thread_queue_t the_proc_modes_mode_m2_globalQueue = {&the_proc_modes_mode_m2_globalQueue_rez, &the_proc_modes_mode_m2, &the_proc_modes_mode_m2_globalQueue_evt, 0, 0, {&the_proc_modes_mode_m2_p_globalVariable}};
test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_currentState the_proc_modes_mode_m1Parent_BA_currentState = test_osek_modes_modes_refined_refined_model__the_proc_modes_the_proc_modes_mode_m1_currentState_ModeSwitch_init_state;
data_port_t the_receiver_m1_input_data_globalVariable = {&the_receiver_m1_input_data_globalVariable_rez, &c11, sizeof(test_osek_modes__Integer)};
data_port_t the_receiver_input_data_globalVariable_m1 = {&the_receiver_input_data_globalVariable_m1_rez, &the_receiver_input_data_m1_value, sizeof(test_osek_modes__Integer)};
data_port_t the_receiver_input_data_globalVariable_m2 = {&the_receiver_input_data_globalVariable_m2_rez, &the_receiver_input_data_m2_value, sizeof(test_osek_modes__Integer)};
