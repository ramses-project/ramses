#include <types.h>
#include "deployment.h"
void pok_kernel_error
    (uint32_t error)
{
  switch (error)
  {
    case POK_ERROR_KIND_NUMERIC_ERROR:
    {
      pok_kernel_stop();
      break;
    }
    case POK_ERROR_KIND_ILLEGAL_REQUEST:
    {
      pok_kernel_restart();
      break;
    }
  }
}
void pok_partition_error
    (uint8_t partition, uint32_t error)
{
  switch (partition)
  {
    case 0:
      switch (error)
      {
        case POK_ERROR_KIND_NUMERIC_ERROR:
        {
          pok_partition_set_mode(0, POK_PARTITION_MODE_RESTART);
          break;
        }
        case POK_ERROR_KIND_ILLEGAL_REQUEST:
        {
          pok_partition_set_mode(0, POK_PARTITION_MODE_RESTART);
          break;
        }
      }
    break;
  }
}
