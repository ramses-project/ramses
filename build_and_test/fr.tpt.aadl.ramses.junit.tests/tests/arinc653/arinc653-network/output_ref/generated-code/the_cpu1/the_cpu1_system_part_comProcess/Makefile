export DEPLOYMENT_HEADER=$(shell pwd)/main.h
include $(POK_PATH)/misc/mk/config.mk
TARGET = the_cpu1_system_part_comProcess.elf
OBJS = main.o activity.o subprograms.o gtypes.o deployment.o /usr/share/pok/libpok/drivers/rtl8029.o 
all: libpok $(TARGET)

clean: common-clean

include $(POK_PATH)/misc/mk/common-$(ARCH).mk
export COPTS=-I/usr/share/pok -I/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653 -I/data/hudson/jobs/RAMSES_TEST/ramses-SNAPSHOT-bin/configuration/org.eclipse.osgi/bundles/47/1/.cp/aadl_resources/C_runtime/PeriodicDelayed_runtime -I/usr/share/pok/libpok/include -I/usr/share/pok/libpok/ada 
include $(POK_PATH)/misc/mk/rules-partition.mk
include $(POK_PATH)/misc/mk/rules-common.mk
