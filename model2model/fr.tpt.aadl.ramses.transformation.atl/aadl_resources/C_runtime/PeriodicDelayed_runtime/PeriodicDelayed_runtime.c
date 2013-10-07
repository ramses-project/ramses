#include "PeriodicDelayed_runtime.h"
#include <libc/stdio.h>

#define MAX(a, b) a<b ? b : a

/**
 * Compute the index to write in at iteration iteration_counter
 * @param taskID            current writer task
 * @param iteration_counter 
 * @param context           
 * @param CDW               CurrentDeadlineWriterIndex
 */
void Compute_CDW(int taskID, int iteration_counter, periodic_delayed_context_t *context, int * CDW)
{
  // validate taskID
  if (taskID >= context->writer_count) {
    printf("!! taskID %d invalid !! greater than writer count %d\n", taskID, context->writer_count);
    return;
  }
  
  int tmp;
  int SEJD = 0;
  *CDW = 0;

  component_instance_t writer_task_instance = context->writer_instances[taskID]; // current writer task instance
  int writer_task_period = writer_task_instance.period;
  int writer_task_deadline = writer_task_instance.deadline;
  int writing_time = iteration_counter * writer_task_period + writer_task_deadline;
  int simultaneous_writers = 0;
  int other_period, other_deadline;
  int idx;
  char itself = 0;
  component_instance_t other_writer;
  for (idx=0 ; idx < context->writer_count ; idx++) {
    other_writer = context->writer_instances[idx];
    other_period = other_writer.period;
    other_deadline = other_writer.deadline;
    // (t - Dj)/Pj can be negative, and its floor equals to -1
    // we don't handle cases where it equals less than -1...
    if(idx==taskID)
      itself = 1;
    if ((tmp = writing_time - other_deadline) >= 0) {
      SEJD += (tmp / other_period) + 1;
    }
    else
    {
      printf("ERROR, negative writing time %d \n",writing_time - other_deadline );
    }
    if (((writing_time - other_deadline) % other_period) == 0
	&& itself==1) {
      simultaneous_writers++;
    }
  }
  *CDW = SEJD - simultaneous_writers;
  *CDW = *CDW % context->buffer_size;
  if(*CDW < 0)
    *CDW += context->buffer_size;
}

/**
 * Compute the last index to read at iteration iteration_counter
 * @param iteration_counter 
 * @param context           
 * @param CPR    CurrentPeriodReadIndex
 */
void Compute_CPR(int iteration_counter, periodic_delayed_context_t * context, int * CPR)
{
  // for the first iteration we initialize it at 0, but no messages are to be read yet
  *CPR = 0;
  int reader_task_period = context->reader_task_period;
  int reading_time = iteration_counter * reader_task_period;
  int writer_period, writer_deadline;
  int idx;
  component_instance_t writer;
  for (idx=0 ; idx < context->writer_count ; idx++) {
    writer = context->writer_instances[idx];
    writer_period = writer.period;
    writer_deadline = writer.deadline;
    *CPR += ((context->hyperperiod+reading_time - writer_deadline) / writer_period) + 1;
  }
  *CPR = *CPR % context->buffer_size;
  if(*CPR < 0)
    *CPR += context->buffer_size;
}

/**
 * Compute the first index to read at iteration iteration_counter
 * @param iteration_counter 
 * @param context           
 * @param PPR               PreviousPeriodReadIndex
 */
void Compute_PPR(int * PPR, int * CPR, periodic_delayed_context_t * context)
{
	*PPR = (*CPR+1) % context->buffer_size;
}
