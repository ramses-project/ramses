#ifndef _PingPong_Properties_COAL_module_h_
#define _PingPong_Properties_COAL_module_h_

/*  Description of package COAL */
/**
 * @addtogroup COAL
 * @{
 * TODO: COAL description.
 *
 * @}
 */


/* ------------------------- enum Supported_Operating_System ------------------------------- */
/**
 * @enum Supported_Operating_System
 * @brief TODO: Supported_Operating_System description.
 */
typedef enum 
{

  E_SUPPORTED_OPERATING_SYSTEM_POSIX,
  E_SUPPORTED_OPERATING_SYSTEM_ARINC653
} Supported_Operating_System;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevSupported_Operating_System_size_ brevDummyUserType_size_
/*
inline void brevSupported_Operating_System_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __PingPong_Properties_COAL_module_h_ */
