export DEPLOYMENT_HEADER=$(shell pwd)/main.h
include $(POK_PATH)/misc/mk/config.mk
TARGET = the_proc1.elf
OBJS = main.o activity.o subprograms.o gtypes.o deployment.o /home/borde/Dev/develop/ramses/build_and_test/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/common-components/user_code.o 
all: libpok $(TARGET)

clean: common-clean

include $(POK_PATH)/misc/mk/common-$(ARCH).mk
export COPTS=-I/usr/share/pok -I/home/borde/Dev/develop/ramses/build_and_test/fr.tpt.aadl.ramses.junit.tests/tests/arinc653 -I/home/borde/Dev/develop/ramses/model2model/fr.tpt.aadl.ramses.transformation.atl/aadl_resources/C_runtime/PeriodicDelayed_runtime -I/usr/share/pok/libpok/include -I/usr/share/pok/libpok/ada -I/home/borde/Dev/develop/ramses/build_and_test/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/common-components 
include $(POK_PATH)/misc/mk/rules-partition.mk
include $(POK_PATH)/misc/mk/rules-common.mk
