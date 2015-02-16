#ifndef _cbtc_Properties_AADL_module_h_
#define _cbtc_Properties_AADL_module_h_

/*  Description of package AADL */
/**
 * @addtogroup AADL
 * @{
 * TODO: AADL description.
 *
 * @}
 */


/* ------------------------- enum Dispatch_Protocol_Type ------------------------------- */
/**
 * @enum Dispatch_Protocol_Type
 * @brief TODO: Dispatch_Protocol_Type description.
 */
typedef enum 
{

  E_DISPATCH_PROTOCOL_TYPE_PERIODIC,
  E_DISPATCH_PROTOCOL_TYPE_SPORADIC,
  E_DISPATCH_PROTOCOL_TYPE_APERIODIC
} Dispatch_Protocol_Type;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevDispatch_Protocol_Type_size_ brevDummyUserType_size_
/*
inline void brevDispatch_Protocol_Type_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum Size_Units ------------------------------- */
/**
 * @enum Size_Units
 * @brief TODO: Size_Units description.
 */
typedef enum 
{

  E_SIZE_UNITS_KB
} Size_Units;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevSize_Units_size_ brevDummyUserType_size_
/*
inline void brevSize_Units_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum Time_Units ------------------------------- */
/**
 * @enum Time_Units
 * @brief TODO: Time_Units description.
 */
typedef enum 
{

  E_TIME_UNITS_MS
} Time_Units;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevTime_Units_size_ brevDummyUserType_size_
/*
inline void brevTime_Units_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __cbtc_Properties_AADL_module_h_ */
