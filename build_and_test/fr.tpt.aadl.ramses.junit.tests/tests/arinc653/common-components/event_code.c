/**
 * AADL-RAMSES
 * 
 * Copyright ¬© 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

#include "user_code.h"
#include <types.h>
#include <libc/stdio.h>

uint8_t counter=0;

void event_received()
{
  if(counter<10 && counter>1)
    printf("received event: %d\n", counter);
  counter++;
}

void nothing_received()
{
  if(counter<10 && counter>1)
    printf("nothing received\n");
}

void send_event (__event_sender_spg_context * context)
{
  if(counter<10 && counter>1)
  {
    printf("send event\n");
  }
  __aadl_send_output (context->e, NULL);
}
