#!/bin/bash

LIB_PATH='../../../../build_and_test/distribution/lib'

LIBS='<Class-Path>'

FILE='pom.xml'

# var checking

TMP=$(ls -A $LIB_PATH) || exit
TMP=$(ls $FILE) || exit

for file in $(ls -A $LIB_PATH)
do
   LIBS="$LIBS lib\/$file"
done

LIBS="$LIBS<\/Class-Path>"

sed -i "s/<Class-Path>.*<\/Class-Path>/$LIBS/" $FILE

echo "DONE"
