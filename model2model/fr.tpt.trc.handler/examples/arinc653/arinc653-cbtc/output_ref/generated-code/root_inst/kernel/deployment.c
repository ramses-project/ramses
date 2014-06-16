#include <types.h>
#include "deployment.h"
void pok_kernel_error
    (uint32_t error)
{
  switch (error)
  {
    case POK_ERROR_KIND_KERNEL_CONFIG:
    {
      // Ignore
      break;
    }
  }
}
