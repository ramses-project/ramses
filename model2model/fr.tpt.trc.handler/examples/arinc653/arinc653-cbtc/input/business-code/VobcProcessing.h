
#ifndef _VOBC_PROCESSING_
#define _VOBC_PROCESSING_

#include "basic_types.h"

typedef struct
{
  uint32_t direction;        // 0 or 1
  int32_t  acceleration;     // dm/sec2
  int32_t  speed;            // kmh  
  int32_t  distance_m;       // m
  int32_t  distance_mm;      // mm
  int32_t  prev_distance_m;  // m
  int32_t  prev_distance_mm; // mm
  int32_t  limit_position;   // m
  int32_t  maxi_speed;       // kmh
  int32_t  stop_cycle;       
} VobcTrainData_t;

typedef VobcTrainData_t * VobcTrainData_ptr;

extern int32_t 
VobcProcessing_compute_traction_data (VobcTrainData_ptr vobc_train_data);

#endif /* _VOBC_PROCESSING_ */
