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

void receive(uint8_t d)
{
  if(d>0 && d<10)
    printf("received value: %d\n", d);
}

uint8_t value=0;

void send(uint8_t* d)
{
  *d = value;
  value++;
  if(*d>0 && *d<10)
    printf("send value: %d\n", *d);
}
