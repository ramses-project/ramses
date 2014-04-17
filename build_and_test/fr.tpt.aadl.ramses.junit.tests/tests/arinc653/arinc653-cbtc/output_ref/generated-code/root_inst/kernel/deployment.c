#include <types.h>
#include "deployment.h"
void pok_kernel_error
    (uint32_t error)
{
  switch (error)
  {
    case POK_ERROR_KIND_KERNEL_CONFIG:
    {
      break;
      }
      case POK_ERROR_KIND_KERNEL_INIT:
      {
        break;
        }
        case POK_ERROR_KIND_KERNEL_SCHEDULING:
        {
          break;
          }
          case POK_ERROR_KIND_PARTITION_SCHEDULING:
          {
            break;
            }
            case POK_ERROR_KIND_PARTITION_CONFIGURATION:
            {
              break;
              }
              case POK_ERROR_KIND_PARTITION_HANDLER:
              {
                break;
                }
                case POK_ERROR_KIND_PARTITION_INIT:
                {
                  break;
                  }
                  case POK_ERROR_KIND_DEADLINE_MISSED:
                  {
                    break;
                    }
                    case POK_ERROR_KIND_APPLICATION_ERROR:
                    {
                      break;
                      }
                      case POK_ERROR_KIND_NUMERIC_ERROR:
                      {
                        break;
                        }
                        case POK_ERROR_KIND_ILLEGAL_REQUEST:
                        {
                          break;
                          }
                          case POK_ERROR_KIND_STACK_OVERFLOW:
                          {
                            break;
                            }
                            case POK_ERROR_KIND_MEMORY_VIOLATION:
                            {
                              break;
                              }
                              case POK_ERROR_KIND_HARDWARE_FAULT:
                              {
                                break;
                                }
                                case POK_ERROR_KIND_POWER_FAIL:
                                {
                                  break;
                                  }
                                }
                                }
