#include "deployment.h"
test_osek_dataports__Integer the_receiver_p_value;
data_port_t the_receiver_p_globalVariable = {&the_receiver_p_globalVariable_rez, &the_receiver_p_value, sizeof(test_osek_dataports__Integer)};
