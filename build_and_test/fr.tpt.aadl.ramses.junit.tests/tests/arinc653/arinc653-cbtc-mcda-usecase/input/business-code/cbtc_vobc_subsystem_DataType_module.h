#ifndef _cbtc_vobc_subsystem_DataType_module_h_
#define _cbtc_vobc_subsystem_DataType_module_h_

/*  Description of package DataType */
/**
 * @addtogroup DataType
 * @{
 * TODO: DataType description.
 *
 * @}
 */




/* ------------------------- struct TractionData  ------------------------------- */
/**
 * @struct TractionData
 * @brief TODO: TractionData description.
 */
typedef struct 
{
/**
 * @brief TODO: ident description.
 * @public
 */
long ident;
/**
 * @brief TODO: msg_cycle description.
 * @public
 */
long msg_cycle;
/**
 * @brief TODO: acceleration description.
 * @public
 */
long acceleration;
/**
 * @brief TODO: limit_position description.
 * @public
 */
long limit_position;
/**
 * @brief TODO: maxi_speed description.
 * @public
 */
long maxi_speed;
/**
 * @brief TODO: direction description.
 * @public
 */
long direction;
} TractionData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevTractionData_size_ brevDummyUserType_size_
/*
inline void brevTractionData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */

/* ------------------------- struct VobcData  ------------------------------- */
/**
 * @struct VobcData
 * @brief TODO: VobcData description.
 */
typedef struct 
{
/**
 * @brief TODO: ident description.
 * @public
 */
long ident;
/**
 * @brief TODO: train_position_m description.
 * @public
 */
long train_position_m;
/**
 * @brief TODO: train_position_mm description.
 * @public
 */
long train_position_mm;
/**
 * @brief TODO: direction description.
 * @public
 */
long direction;
/**
 * @brief TODO: speed description.
 * @public
 */
long speed;
} VobcData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevVobcData_size_ brevDummyUserType_size_
/*
inline void brevVobcData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */

/* ------------------------- struct OdometerData  ------------------------------- */
/**
 * @struct OdometerData
 * @brief TODO: OdometerData description.
 */
typedef struct 
{
/**
 * @brief TODO: ident description.
 * @public
 */
long ident;
/**
 * @brief TODO: wheel_angle description.
 * @public
 */
long wheel_angle;
/**
 * @brief TODO: speed description.
 * @public
 */
long speed;
} OdometerData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevOdometerData_size_ brevDummyUserType_size_
/*
inline void brevOdometerData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */



#endif /* __cbtc_vobc_subsystem_DataType_module_h_ */
