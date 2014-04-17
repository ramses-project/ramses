export DEPLOYMENT_HEADER=$(shell pwd)/main.h
include $(POK_PATH)/misc/mk/config.mk
TARGET = S1_inst.elf
OBJS = main.o activity.o subprograms.o gtypes.o deployment.o /data/hudson/jobs/RAMSES-Test/workspace/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-pingpong/input/pingpong.o 
all: libpok $(TARGET)

clean: common-clean

include $(POK_PATH)/misc/mk/common-$(ARCH).mk
export COPTS=-I/usr/share/pok -I/data/hudson/jobs/RAMSES-Test/workspace/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-pingpong/input -I/data/hudson/jobs/RAMSES-Test/workspace/fr.tpt.aadl.ramses.junit.tests/../ramses-SNAPSHOT-bin/aadl_resources/C_runtime/PeriodicDelayed_runtime -I/usr/share/pok/libpok/include -I/usr/share/pok/libpok/ada -I/data/hudson/jobs/RAMSES-Test/workspace/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-pingpong/input 
include $(POK_PATH)/misc/mk/rules-partition.mk
include $(POK_PATH)/misc/mk/rules-common.mk
