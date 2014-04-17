#ifndef _cbtc_Properties_ARINC653_module_h_
#define _cbtc_Properties_ARINC653_module_h_

/*  Description of package ARINC653 */
/**
 * @addtogroup ARINC653
 * @{
 * TODO: ARINC653 description.
 *
 * @}
 */


/* ------------------------- enum Supported_DAL_Type ------------------------------- */
/**
 * @enum Supported_DAL_Type
 * @brief TODO: Supported_DAL_Type description.
 */
typedef enum 
{

  E_SUPPORTED_DAL_TYPE_A,
  E_SUPPORTED_DAL_TYPE_B,
  E_SUPPORTED_DAL_TYPE_C,
  E_SUPPORTED_DAL_TYPE_D,
  E_SUPPORTED_DAL_TYPE_E
} Supported_DAL_Type;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevSupported_DAL_Type_size_ brevDummyUserType_size_
/*
inline void brevSupported_DAL_Type_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __cbtc_Properties_ARINC653_module_h_ */
