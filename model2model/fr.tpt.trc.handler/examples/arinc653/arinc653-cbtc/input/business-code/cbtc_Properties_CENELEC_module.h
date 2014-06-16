#ifndef _cbtc_Properties_CENELEC_module_h_
#define _cbtc_Properties_CENELEC_module_h_

/*  Description of package CENELEC */
/**
 * @addtogroup CENELEC
 * @{
 * TODO: CENELEC description.
 *
 * @}
 */


/* ------------------------- enum Supported_SIL_Level ------------------------------- */
/**
 * @enum Supported_SIL_Level
 * @brief TODO: Supported_SIL_Level description.
 */
typedef enum 
{

  E_SUPPORTED_SIL_LEVEL_SIL0,
  E_SUPPORTED_SIL_LEVEL_SIL2,
  E_SUPPORTED_SIL_LEVEL_SIL4
} Supported_SIL_Level;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevSupported_SIL_Level_size_ brevDummyUserType_size_
/*
inline void brevSupported_SIL_Level_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __cbtc_Properties_CENELEC_module_h_ */
