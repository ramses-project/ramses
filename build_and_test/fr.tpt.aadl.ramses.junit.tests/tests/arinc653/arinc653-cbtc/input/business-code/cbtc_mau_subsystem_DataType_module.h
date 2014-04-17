#ifndef _cbtc_mau_subsystem_DataType_module_h_
#define _cbtc_mau_subsystem_DataType_module_h_

/*  Description of package DataType */
/**
 * @addtogroup DataType
 * @{
 * TODO: DataType description.
 *
 * @}
 */




/* ------------------------- struct TrainPosition  ------------------------------- */
/**
 * @struct TrainPosition
 * @brief TODO: TrainPosition description.
 */
typedef struct 
{
/**
 * @brief TODO: train_position description.
 * @public
 */
long train_position;
/**
 * @brief TODO: train_direction description.
 * @public
 */
long train_direction;
} TrainPosition;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevTrainPosition_size_ brevDummyUserType_size_
/*
inline void brevTrainPosition_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */

/* ------------------------- struct EndOfAuthority  ------------------------------- */
/**
 * @struct EndOfAuthority
 * @brief TODO: EndOfAuthority description.
 */
typedef struct 
{
/**
 * @brief TODO: ident description.
 * @public
 */
long ident;
/**
 * @brief TODO: limit_position description.
 * @public
 */
long limit_position;
} EndOfAuthority;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevEndOfAuthority_size_ brevDummyUserType_size_
/*
inline void brevEndOfAuthority_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */

/* ------------------------- struct MauData  ------------------------------- */
/**
 * @struct MauData
 * @brief TODO: MauData description.
 */
typedef struct 
{
/**
 * @brief TODO: ident description.
 * @public
 */
long ident;
/**
 * @brief TODO: train_position description.
 * @public
 */
long train_position;
} MauData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevMauData_size_ brevDummyUserType_size_
/*
inline void brevMauData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */



#endif /* __cbtc_mau_subsystem_DataType_module_h_ */
