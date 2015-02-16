
#ifndef _TOOLS_
#define _TOOLS_

#include "basic_types.h"

extern  
int32_t get_currindex (const int32_t* table, int32_t n_elems, int32_t value);

extern  
int32_t get_nextindex (const int32_t* table, int32_t n_elems, 
                       int32_t value, int32_t direction);


extern  
int32_t get_tabvalue (const int32_t* tablex, const int32_t* tabley, 
                      int32_t n_elems, int32_t value);


#endif /* _TOOLS_ */
