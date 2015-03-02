#include "deployment.h"
test_osek_eventdataports_refined_model__the_receiver_p_bufferType the_receiver_p_value;
port_queue_t the_receiver_p_globalVariable = {5, 0, 0, 0, sizeof(test_osek_eventdataports__Integer), the_receiver_p_value, 0};
thread_queue_t the_receiver_globalQueue = {&the_receiver_globalQueue_rez, &the_receiver, &the_receiver_globalQueue_evt, 0, 0, {&the_receiver_p_globalVariable}};
