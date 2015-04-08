#ifndef __GENERATED_DEPLOYMENT_H__
#define __GENERATED_DEPLOYMENT_H__

#include "routing.h"
#define POK_NEEDS_CONSOLE 1
#define POK_NEEDS_CONSOLE 1
#define POK_CONFIG_LOCAL_NODE 0
#define POK_GENERATED_CODE 1
#define POK_NEEDS_GETTICK 1
#define POK_NEEDS_THREADS 1
#define POK_NEEDS_PARTITIONS 1
#define POK_NEEDS_DEBUG 1
#define POK_NEEDS_SCHED 1
#define POK_CONFIG_NB_PARTITIONS 2
#define POK_CONFIG_NB_THREADS 6
#define POK_CONFIG_PARTITIONS_NTHREADS {2,2}
#define POK_NEEDS_SCHED_RMS 1
#define POK_NEEDS_SCHED_RMS 1
#define POK_CONFIG_PARTITIONS_SCHEDULER {POK_SCHED_RMS,POK_SCHED_RMS}
#define POK_NEEDS_PORTS_QUEUEING 1
#define POK_NEEDS_THREAD_ID 1
#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {0,0}
#define POK_CONFIG_PARTITIONS_SIZE {150000,150000}
#define POK_CONFIG_SCHEDULING_NBSLOTS 3
#define POK_CONFIG_SCHEDULING_SLOTS {2000,1000,1000}
#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {0,0,1}
#define POK_CONFIG_SCHEDULING_MAJOR_FRAME 4000
#define POK_NEEDS_FLUSH_ON_WINDOWS
#define POK_CONFIG_STACKS_SIZE 80000
#define POK_CONFIG_NB_BUSES 0
#define POK_NEEDS_ERROR_HANDLING 1
#define POK_USE_GENERATED_KERNEL_ERROR_HANDLER 1
#define POK_USE_GENERATED_PARTITION_ERROR_HANDLER 1
#include "core/partition.h"
#include "core/error.h"
#include "core/kernel.h"
#endif
