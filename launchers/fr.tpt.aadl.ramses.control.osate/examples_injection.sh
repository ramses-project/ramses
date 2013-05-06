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
EXAMPLE_DIRECTORY="${SCRIPT_DIR}/examples"
OUTPUTREF_DIR_NAME="output_ref"
CLEAN="FALSE"
CP_OPTIONS="-rp"

if [ "$2" != "" ]
   then TESTS_ROOT_DIRECTORY="$2"
   else TESTS_ROOT_DIRECTORY="${SCRIPT_DIR}/../../../../build_and_test/junit_tests/tests"
fi

if [ "$1" == "--force" ]
   then CLEAN="TRUE"
   else CP_OPTIONS="${CP_OPTIONS}i"
fi   

if [ CLEAN == "TRUE" ] ; then
  rm -fr ${EXAMPLE_DIRECTORY}
fi

mkdir -p ${EXAMPLE_DIRECTORY}
cp ${CP_OPTIONS} ${TESTS_ROOT_DIRECTORY}/* ${EXAMPLE_DIRECTORY}

find ${EXAMPLE_DIRECTORY} -type d -name "${OUTPUTREF_DIR_NAME}" -exec rm -fr {} \;

echo "Examples for RAMSES-OSATE have been sucessfuly copied."
