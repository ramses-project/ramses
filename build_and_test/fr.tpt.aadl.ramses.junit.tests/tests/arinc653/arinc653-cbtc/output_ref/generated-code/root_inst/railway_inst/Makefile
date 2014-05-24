export DEPLOYMENT_HEADER=$(shell pwd)/main.h
include $(POK_PATH)/misc/mk/config.mk
TARGET = railway_inst.elf
OBJS = main.o activity.o subprograms.o gtypes.o deployment.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_mau_subsystem_Implementations_TrainPositionsCorrelation_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/Tools.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_mau_subsystem_Implementations_EndOfAuthorityComputation_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_mau_subsystem_Implementations_EoaSending_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_viu_subsystem_Implementations_ViuTrainPositionEstimation_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_viu_subsystem_Implementations_ViuTrainPositionSending_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_cbtc_subsystem_Implementations_TrainSimu_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_trainPpu_subsystem_Implementations_TrackPpu_impl.o /data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input/business-code/cbtc_viu_subsystem_Implementations_TrackAcquisition_impl.o 
all: libpok $(TARGET)

clean: common-clean

include $(POK_PATH)/misc/mk/common-$(ARCH).mk
export COPTS=-I/usr/share/pok -I/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input -I/data/hudson/jobs/RAMSES_TEST/ramses-SNAPSHOT-bin/configuration/org.eclipse.osgi/bundles/46/1/.cp/aadl_resources/C_runtime/PeriodicDelayed_runtime -I/usr/share/pok/libpok/include -I/usr/share/pok/libpok/ada -I/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/arinc653/arinc653-cbtc/input 
include $(POK_PATH)/misc/mk/rules-partition.mk
include $(POK_PATH)/misc/mk/rules-common.mk
