#ifndef _PERIODICDELAYED_RUNTIME_C
#define _PERIODICDELAYED_RUNTIME_C

/**
 * Data of a task
 */
typedef struct component_instance_t
{
  int  period;
  int  deadline;
} component_instance_t;

/**
 * Auto-generated
 */
typedef struct periodic_delayed_context_t
{
  int reader_task_period; 	// reader task period
  component_instance_t * writer_instances; // writer tasks data
  int writer_count; 			// writer tasks number
  int buffer_size;
  int hyperperiod;
} periodic_delayed_context_t;

void Compute_CDW(int taskID, int  iteration_counter, periodic_delayed_context_t *context, int * CDW);
void Compute_CPR(int iteration_counter, periodic_delayed_context_t *context, int * CPR);
void Compute_PPR(int * PPR, int * CPR, periodic_delayed_context_t * context);

#endif

