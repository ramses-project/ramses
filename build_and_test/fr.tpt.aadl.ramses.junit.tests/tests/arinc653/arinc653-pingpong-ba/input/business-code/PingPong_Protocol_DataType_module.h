#ifndef _PingPong_Protocol_DataType_module_h_
#define _PingPong_Protocol_DataType_module_h_

/*  Description of package DataType */
/**
 * @addtogroup DataType
 * @{
 * TODO: DataType description.
 *
 * @}
 */


/* ------------------------- enum ID ------------------------------- */
/**
 * @enum ID
 * @brief TODO: ID description.
 */
typedef enum 
{

  E_ID_C1,
  E_ID_C2
} ID;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevID_size_ brevDummyUserType_size_
/*
inline void brevID_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum ROLE ------------------------------- */
/**
 * @enum ROLE
 * @brief TODO: ROLE description.
 */
typedef enum 
{

  E_ROLE_CPING,
  E_ROLE_CPONG
} ROLE;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevROLE_size_ brevDummyUserType_size_
/*
inline void brevROLE_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */
/* ------------------------- enum TYPE ------------------------------- */
/**
 * @enum TYPE
 * @brief TODO: TYPE description.
 */
typedef enum 
{

  E_TYPE_PING,
  E_TYPE_PONG
} TYPE;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevTYPE_size_ brevDummyUserType_size_
/*
inline void brevTYPE_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */

/* ------------------------- typedef SEQ ------------------------------- */
/**
 * @struct SEQ
 * @brief TODO: SEQ description.
 */
typedef int SEQ;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevSEQ_size_ brevDummyUserType_size_
/*
inline void brevSEQ_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */


/* ------------------------- struct PingPongMessage  ------------------------------- */
/**
 * @struct PingPongMessage
 * @brief TODO: PingPongMessage description.
 */
typedef struct 
{
/**
 * @brief TODO: m_type description.
 * @public
 */
TYPE m_type;
/**
 * @brief TODO: m_sender description.
 * @public
 */
ID m_sender;
/**
 * @brief TODO: m_seqNb description.
 * @public
 */
SEQ m_seqNb;
} PingPongMessage;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevPingPongMessage_size_ brevDummyUserType_size_
/*
inline void brevPingPongMessage_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */



#endif /* __PingPong_Protocol_DataType_module_h_ */
