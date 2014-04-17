#include "Tools.h"


int32_t get_currindex (const int32_t* table, int32_t n_elems, int32_t value)
{
  int32_t index = -1;
  int32_t index_max = n_elems-1;

  if (value <= table[0])
  {
    index = 0;
  }
  else if (value >= table[index_max])
  {
    index = index_max;
  }
  else
  {
    int32_t i;
  
    for (i=0; i < index_max && index == -1 ; i++)
    {    
      if (value == table[i])
      {
        index = i;
      }
      else if (value > table[i] && value < table[i+1])
      {
        index = i;
      }
    }
  }
  
  return index;
}

int32_t get_nextindex (const int32_t* table, int32_t n_elems, int32_t value, int32_t direction)
{
  int32_t index = -1;
  int32_t index_max = n_elems-1;

  if (value <= table[0])
  {
    index = 0;
  }
  else if (value >= table[index_max])
  {
    index = index_max;
  }
  else
  {
    if (direction == 0)
    {
      int32_t i;

      for (i=0; i < n_elems && index == -1 ; i++)
      {
        if (value == table[i])
        {
          index = i;
        }
        else if (i != 0)
        {
          if (value > table[i-1] && value < table[i])
          {
            index = i;
          }
        } 
      }
    }
    else
    {
      int32_t i;

      for (i=n_elems-1; i >= 0 && index == -1 ; i--)
      {
        if (value == table[i])
        {
          index = i;
        }
        else if (i != n_elems-1)
        {
          if (value > table[i] && value < table[i+1])
          {
            index = i;
          }
        }    
      }
    }
  }
  
  return index;
}

int32_t get_tabvalue (const int32_t* tablex, const int32_t* tabley, 
                      int32_t n_elems, int32_t value)
{
  int32_t ret_value;
  
  syslog (LOG_USER | LOG_INFO, "get_tabvalue() begin, nelems %d value %d", 
          n_elems, value);
  
  // first find the index in tablex
  int32_t tab_index = get_currindex (tablex, n_elems, value);
  
  syslog (LOG_USER | LOG_INFO, "get_tabvalue(), tab_index %d", 
          tab_index);
  
  // if last index of table
  if (tab_index == n_elems-1)
  {
    ret_value = tabley[tab_index];
  }
  else
  {
    int32_t deltax1 = tablex[tab_index + 1] - tablex[tab_index];
    int32_t deltax2 = value - tablex[tab_index];
    
    if (deltax2 == 0)
    {
      ret_value = tabley[tab_index];
    }
    else
    {
      ret_value = tabley[tab_index] + 
                  ((tabley[tab_index + 1] - tabley[tab_index]) * deltax2 / deltax1); 
    }
    
    syslog (LOG_USER | LOG_INFO, "get_tabvalue(), deltax1 %d deltax2 %d", 
          deltax1, deltax2);
  }
  
  syslog (LOG_USER | LOG_INFO, "get_tabvalue(), ret_value %d", 
          ret_value);
  
  return ret_value;
}


