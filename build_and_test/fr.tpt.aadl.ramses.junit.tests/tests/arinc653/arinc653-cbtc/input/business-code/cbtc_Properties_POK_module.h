#ifndef _cbtc_Properties_POK_module_h_
#define _cbtc_Properties_POK_module_h_

/*  Description of package POK */
/**
 * @addtogroup POK
 * @{
 * TODO: POK description.
 *
 * @}
 */


/* ------------------------- enum Scheduler_Type ------------------------------- */
/**
 * @enum Scheduler_Type
 * @brief TODO: Scheduler_Type description.
 */
typedef enum 
{

  E_SCHEDULER_TYPE_STATIC,
  E_SCHEDULER_TYPE_RR
} Scheduler_Type;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevScheduler_Type_size_ brevDummyUserType_size_
/*
inline void brevScheduler_Type_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum Architecture_enum ------------------------------- */
/**
 * @enum Architecture_enum
 * @brief TODO: Architecture_enum description.
 */
typedef enum 
{

  E_ARCHITECTURE_ENUM_X86,
  E_ARCHITECTURE_ENUM_68K
} Architecture_enum;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevArchitecture_enum_size_ brevDummyUserType_size_
/*
inline void brevArchitecture_enum_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum Additional_Features_Type ------------------------------- */
/**
 * @enum Additional_Features_Type
 * @brief TODO: Additional_Features_Type description.
 */
typedef enum 
{

  E_ADDITIONAL_FEATURES_TYPE_LIBC_STDIO,
  E_ADDITIONAL_FEATURES_TYPE_CONSOLE
} Additional_Features_Type;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevAdditional_Features_Type_size_ brevDummyUserType_size_
/*
inline void brevAdditional_Features_Type_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum BSP_enum ------------------------------- */
/**
 * @enum BSP_enum
 * @brief TODO: BSP_enum description.
 */
typedef enum 
{

  E_BSP_ENUM_X86_QEMU,
  E_BSP_ENUM_68K_QEMU
} BSP_enum;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevBSP_enum_size_ brevDummyUserType_size_
/*
inline void brevBSP_enum_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __cbtc_Properties_POK_module_h_ */
