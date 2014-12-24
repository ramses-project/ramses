#ifndef __GENERATED_DEPLOYMENT_H__
#define __GENERATED_DEPLOYMENT_H__

#include "routing.h"
#define POK_NEEDS_CONSOLE 1
#define POK_CONFIG_LOCAL_NODE 0
#define POK_GENERATED_CODE 1
#define POK_NEEDS_GETTICK 1
#define POK_NEEDS_THREADS 1
#define POK_NEEDS_PARTITIONS 1
#define POK_NEEDS_DEBUG 1
#define POK_NEEDS_SCHED 1
#define POK_CONFIG_NB_PARTITIONS 1
#define POK_CONFIG_NB_THREADS 6
#define POK_CONFIG_PARTITIONS_NTHREADS {4}
#define POK_NEEDS_SCHED_RR 1
#define POK_CONFIG_PARTITIONS_SCHEDULER {POK_SCHED_RR}
#define POK_NEEDS_LOCKOBJECTS 1
#define POK_NEEDS_PORTS_BUFFER 1
#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {4}
#define POK_CONFIG_PARTITIONS_SIZE {200000}
#define POK_CONFIG_SCHEDULING_NBSLOTS 1
#define POK_CONFIG_SCHEDULING_SLOTS {2000}
#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {0}
#define POK_CONFIG_SCHEDULING_MAJOR_FRAME 2000
#define POK_CONFIG_STACKS_SIZE 120000
#define POK_CONFIG_NB_BUSES 0
#define POK_NEEDS_ERROR_HANDLING 1
#define POK_USE_GENERATED_KERNEL_ERROR_HANDLER 1
#define POK_USE_GENERATED_PARTITION_ERROR_HANDLER 1
#include "core/partition.h"
#include "core/error.h"
#include "core/kernel.h"
#endif
