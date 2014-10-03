#!/bin/bash -x

################################## USAGE #######################################

# if arg == linux => for Linux 64 bits
#           mac => for Mac OS X 64 bits

################################## NAMING ######################################

SCRIPT_DIR=`dirname $0`; cd ${SCRIPT_DIR}; SCRIPT_DIR=`pwd`

POM_DIR='fr.tpt.aadl.ramses.build.main'

JUNIT_DIR='fr.tpt.aadl.ramses.junit.tests'

RAMSES_DIR='ramses-SNAPSHOT-bin'

PRODUCT_DIR='fr.tpt.aadl.ramses.control.cli.osgi.product/target/products'

ZIP_FILE_PREFIX='osate2-cli'

LINUX_SUFFIX='-linux.gtk.x86_64.zip'

MAC_SUFFIX='-macosx.cocoa.x86_64.zip'

LOG_FILE='test.log'

################################## MAIN ########################################

case $1 in
  'linux') ZIP_FILE=${ZIP_FILE_PREFIX}${LINUX_SUFFIX} ;;
  'mac') ZIP_FILE=${ZIP_FILE_PREFIX}${MAC_SUFFIX} ;;
esac  

cd ${POM_DIR}
mvn clean install || exit -1 # Build RAMSES.
cd ..
rm -fr ${RAMSES_DIR} # Clean any previous RAMSES deployment.
cp ${PRODUCT_DIR}/${ZIP_FILE} .
unzip ${ZIP_FILE}
mv ${ZIP_FILE_PREFIX} ${RAMSES_DIR}
rm ${ZIP_FILE}
cd ${JUNIT_DIR}
mvn clean test > ${LOG_FILE}
cd ..
