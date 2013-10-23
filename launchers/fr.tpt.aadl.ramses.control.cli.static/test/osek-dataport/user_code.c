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

void receive(char d)
{
  char hcount,lcount;
  for (hcount = 0; hcount < 10; hcount++) {
    for (lcount = 0; lcount < 3200; lcount++) ;
    ecrobot_debug1(d, hcount, 0);
  }
}

char value=0;

void send(char* d)
{
  char hcount, lcount;
  *d = value;
  value++;
  for (hcount = 0; hcount < 10; hcount++) {
    for (lcount = 0; lcount < 3200; lcount++) ;
    ecrobot_debug2(*d, hcount, 0);
  }
}
