#include <stdio.h>
#include <stdlib.h>
#include "../PeriodicDelayed_runtime.h"

/**
 * T0: writer, P0 = 7
 * T1: writer, P1 = 10
 * Tr: reader, Pr = 10
 */

void main(int argv, char *argc[])
{

  component_instance *writer_instances;
  unsigned short writer_count;

  struct periodic_delayed_context_t *writer0_context;
  struct periodic_delayed_context_t *writer1_context;
  struct periodic_delayed_context_t *reader_context;

  unsigned short reader_task_period;
  unsigned short buffer_size;
  unsigned short hyperperiod;

  printf("Allocations...\n");

  writer_instances = (component_instance *) malloc(writer_count*sizeof(component_instance));

  writer0_context = (struct periodic_delayed_context_t *) malloc(sizeof(struct periodic_delayed_context_t));
  writer1_context = (struct periodic_delayed_context_t *) malloc(sizeof(struct periodic_delayed_context_t));
  reader_context = (struct periodic_delayed_context_t *) malloc(sizeof(struct periodic_delayed_context_t));
  

  printf("Initializing context...\t");

  reader_task_period = 10;

  buffer_size = 9; // TO CHECK
  hyperperiod = 70; // ppcm(P0, P1, Pr)

  writer_count = 2;
 
  writer_instances[0].period = 7;
  writer_instances[0].deadline = 7;
  writer_instances[1].period = 10;
  writer_instances[1].deadline = 10;

  //writer0_context->taskID = 0;
  writer0_context->portID = P1;
  writer0_context->reader_task_period = reader_task_period;
  writer0_context->writer_instances = writer_instances;
  writer0_context->writer_count = writer_count;
  writer0_context->buffer_size = buffer_size;
  writer0_context->hyperperiod = hyperperiod;

  //writer1_context->taskID = 1;
  writer1_context->portID = P1;
  writer1_context->reader_task_period = reader_task_period;
  writer1_context->writer_instances = writer_instances;
  writer1_context->writer_count = writer_count;
  writer1_context->buffer_size = buffer_size;
  writer1_context->hyperperiod = hyperperiod;

  reader_context->portID = P1;
  reader_context->reader_task_period = reader_task_period;
  reader_context->writer_instances = writer_instances;
  reader_context->writer_count = writer_count;
  reader_context->buffer_size = buffer_size;
  reader_context->hyperperiod = hyperperiod;
  
  printf("[DONE]\n");
  
  printf("Begin !\n");

  int iteration;
 
  unsigned short CPR;
  unsigned short PPR;
  unsigned short CDW;

  for (iteration=0 ; iteration < 10 ; iteration++) {
    printf("\n>> Iteration %d : \n", iteration);

    Compute_CDW(0, iteration, writer0_context, &CDW);

    printf("[Writer 0] CDW = %d\n", CDW);

    Compute_CDW(1, iteration, writer1_context, &CDW);

    printf("[Writer 1] CDW = %d\n", CDW);

    Compute_CPR(iteration, reader_context, &CPR);
    Compute_PPR(iteration, reader_context, &PPR);

    printf("[Reader] CPR = %d\n", CPR);
    printf("[Reader] PPR = %d\n", PPR);

    printf("********************\n");
  }

}
