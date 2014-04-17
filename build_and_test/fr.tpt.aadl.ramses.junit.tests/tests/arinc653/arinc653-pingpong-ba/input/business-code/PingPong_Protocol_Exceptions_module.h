#ifndef _PingPong_Protocol_Exceptions_module_h_
#define _PingPong_Protocol_Exceptions_module_h_

/*  Description of package Exceptions */
/**
 * @addtogroup Exceptions
 * @{
 * TODO: Exceptions description.
 *
 * @}
 */


/* ------------------------- enum Exception ------------------------------- */
/**
 * @enum Exception
 * @brief TODO: Exception description.
 */
typedef enum 
{

  E_EXCEPTION_NO_ERROR,
  E_EXCEPTION_BAD_SEQUENCE_NUMBER
} Exception;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevException_size_ brevDummyUserType_size_
/*
inline void brevException_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */




#endif /* __PingPong_Protocol_Exceptions_module_h_ */
