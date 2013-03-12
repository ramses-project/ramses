#!/bin/bash

# AADL-RAMSES
 
# Copyright © 2013 TELECOM ParisTech and CNRS
 
# TELECOM ParisTech/LTCI
 
# Authors: see AUTHORS
  
# This program is free software: you can redistribute it and/or modify 
# it under the terms of the Eclipse Public License as published by Eclipse,
# either version 1.0 of the License, or (at your option) any later version.
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# Eclipse Public License for more details.
# You should have received a copy of the Eclipse Public License
# along with this program.  If not, see 
# http://www.eclipse.org/org/documents/epl-v10.php

# Naming

SCRIPT_DIR=`dirname $0`; cd ${SCRIPT_DIR}; SCRIPT_DIR=`pwd`
LIB_PATH="${SCRIPT_DIR}/../../../../build_and_test/distribution/lib"
LIBS='<Class-Path>'
POM_FILE="${SCRIPT_DIR}/pom.xml"

# Functions

function die
{
   echo -e "${1}" 1>&2
   exit
}

# Name checking

if [ ! -d "${LIB_PATH}" ] ; then
   ERROR_MSG[0]='lib directory is not found.'
fi

if [ ! -f "${POM_FILE}" ] ; then
   ERROR_MSG[1]='pom.xml is not found.'
fi

if [ ! "${#ERROR_MSG[*]}" = '0' ] ; then
   MSG=''
   for index in ${!ERROR_MSG[*]}
   do
      MSG="${MSG}${ERROR_MSG[index]}\n"
   done
   die "${MSG}Abort."
fi

# Main

for file in $(ls -A "${LIB_PATH}")
do
   LIBS="${LIBS} lib\/${file}"
done

LIBS="${LIBS}<\/Class-Path>"

sed -i "s/<Class-Path>.*<\/Class-Path>/${LIBS}/" "${POM_FILE}" || die 'substitution error. Abort.'

echo "pom.xml is updated"
