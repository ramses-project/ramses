export DEPLOYMENT_HEADER=$(shell pwd)/main.h
include $(POK_PATH)/misc/mk/config.mk
TARGET = train_inst.elf
OBJS = main.o activity.o subprograms.o gtypes.o deployment.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_trainPpu_subsystem_Implementations_TrainPpu_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/VobcProcessing.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/Tools.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_vobc_subsystem_Implementations_WheelAngleAcquisition_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_vobc_subsystem_Implementations_VobcTrainPositionEstimation_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_vobc_subsystem_Implementations_VobcTrainPositionSending_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_vobc_subsystem_Implementations_TrainSpeedAccelCompute_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_vobc_subsystem_Implementations_AccelerationSending_impl.o 
all: libpok $(TARGET)

clean: common-clean

include $(POK_PATH)/misc/mk/common-$(ARCH).mk
export COPTS=-I"/usr/share/pok" -I"/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input" -I"/data/hudson/jobs/RAMSES_TEST/ramses-SNAPSHOT-bin/configuration/org.eclipse.osgi/31/0/.cp/aadl_resources/C_runtime/PeriodicDelayed_runtime" -I"/usr/share/pok/libpok/include" -I"/usr/share/pok/libpok/ada" -I"/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input" 
include $(POK_PATH)/misc/mk/rules-partition.mk
include $(POK_PATH)/misc/mk/rules-common.mk
