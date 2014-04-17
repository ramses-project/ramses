
//******************************************************************************
//                                 INCLUSION                                 

#include "main.h"
#include "string.h"
#include "stdio.h"
extern void test_buffer_delayed_refined_the_proc_the_sender_impl_Job();
extern void test_buffer_delayed_refined_the_proc_the_receiver_impl_Job();

//******************************************************************************
//                              GLOBAL VARIABLES                             

PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];

//******************************************************************************
//                                    MAIN                                   

extern void Init_Global_Variables();
int main ()
{
  Init_Global_Variables();
    PROCESS_ATTRIBUTE_TYPE tattr;
    RETURN_CODE_TYPE ret;
    tattr.ENTRY_POINT = test_buffer_delayed_refined_the_proc_the_sender_impl_Job;
    tattr.PERIOD = 1000;
    tattr.DEADLINE = 1000;
    tattr.TIME_CAPACITY = 1;
    tattr.BASE_PRIORITY = 5;
    strcpy(tattr.NAME, "the_sender");
    CREATE_PROCESS (&(tattr), &(arinc_threads[1]), &(ret));
    START (arinc_threads[1], &(ret));
    tattr.ENTRY_POINT = test_buffer_delayed_refined_the_proc_the_receiver_impl_Job;
    tattr.PERIOD = 200;
    tattr.DEADLINE = 200;
    tattr.TIME_CAPACITY = 1;
    tattr.BASE_PRIORITY = 10;
    strcpy(tattr.NAME, "the_receiver");
    CREATE_PROCESS (&(tattr), &(arinc_threads[2]), &(ret));
    START (arinc_threads[2], &(ret));
    SET_PARTITION_MODE (NORMAL, &(ret));
    return (0);
}

//******************************************************************************
