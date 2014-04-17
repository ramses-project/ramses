#ifndef _PingPong_dataType_deployment_h_
#define _PingPong_dataType_deployment__h_

/* support for workstations with different byte orders */

/* 
   This file is mainly used for distributed configuration of the ping-pong example.
   For simplification purposes, we suppose here 
   that all workstations have the same byte order,
   so the operations called by SynDEx to change the byte order
   of user specific data types are empty.
*/

inline void brevDummyUserType_size_(int* data, int items)
{
  (void)data;
  (void)items;
  return;
}

#endif /* _PingPong_dataType_deployment_h_ */
