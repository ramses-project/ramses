#ifndef _cbtc_viu_subsystem_DataType_module_h_
#define _cbtc_viu_subsystem_DataType_module_h_

/*  Description of package DataType */
/**
 * @addtogroup DataType
 * @{
 * TODO: DataType description.
 *
 * @}
 */




/* ------------------------- struct CdvData  ------------------------------- */
/**
 * @struct CdvData
 * @brief TODO: CdvData description.
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
} CdvData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevCdvData_size_ brevDummyUserType_size_
/*
inline void brevCdvData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */

/* ------------------------- struct ViuData  ------------------------------- */
/**
 * @struct ViuData
 * @brief TODO: ViuData description.
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
/**
 * @brief TODO: direction description.
 * @public
 */
long direction;
} ViuData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevViuData_size_ brevDummyUserType_size_
/*
inline void brevViuData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */



#endif /* __cbtc_viu_subsystem_DataType_module_h_ */
