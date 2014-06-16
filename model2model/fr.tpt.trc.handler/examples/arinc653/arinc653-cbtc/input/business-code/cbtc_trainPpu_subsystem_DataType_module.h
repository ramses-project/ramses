#ifndef _cbtc_trainPpu_subsystem_DataType_module_h_
#define _cbtc_trainPpu_subsystem_DataType_module_h_

/*  Description of package DataType */
/**
 * @addtogroup DataType
 * @{
 * TODO: DataType description.
 *
 * @}
 */



/* ------------------------- typedef TrainPositionOffset ------------------------------- */
/**
 * @struct TrainPositionOffset
 * @brief TODO: TrainPositionOffset description.
 */
typedef long TrainPositionOffset;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevTrainPositionOffset_size_ brevDummyUserType_size_
/*
inline void brevTrainPositionOffset_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __cbtc_trainPpu_subsystem_DataType_module_h_ */
