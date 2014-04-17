#include <types.h>
#include "deployment.h"
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
          pok_partition_set_mode(0, POK_PARTITION_MODE_STOPPED);
          break;
          }
          case POK_ERROR_KIND_ILLEGAL_REQUEST:
          {
            pok_partition_set_mode(0, POK_PARTITION_MODE_RESTART);
            break;
            }
          }
        break;
        case 1:
          switch (error)
          {
            case POK_ERROR_KIND_NUMERIC_ERROR:
            {
              pok_partition_set_mode(1, POK_PARTITION_MODE_STOPPED);
              break;
              }
              case POK_ERROR_KIND_ILLEGAL_REQUEST:
              {
                pok_partition_set_mode(1, POK_PARTITION_MODE_RESTART);
                break;
                }
              }
            break;
            }
          }
