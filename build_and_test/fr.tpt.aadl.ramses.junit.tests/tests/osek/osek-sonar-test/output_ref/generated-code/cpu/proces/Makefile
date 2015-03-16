TARGET = proces_OSEK
TOPPERS_OSEK_OIL_SOURCE = ./proces.oil
TARGET_SOURCES = \
	main.c\
	activity.c\
	subprograms.c\
	gtypes.c\
	deployment.c\
	/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/osek/osek-sonar-test/input/show.c
export USER_INCLUDES=\n	/data/packages/nxtOSEK\
	/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/osek/osek-lego-devices-commons\
	/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/osek/osek-lego-devices-commons\
	/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/osek/osek-sonar-test/input\
	/data/hudson/jobs/RAMSES_TEST/ramses-SNAPSHOT-bin/configuration/org.eclipse.osgi/31/0/.cp/aadl_resources/C_runtime/PeriodicDelayed_runtime\
	/data/hudson/jobs/RAMSES_TEST/ramses-SNAPSHOT-bin/configuration/org.eclipse.osgi/31/0/.cp/aadl_resources/C_runtime/OSEK\
	/data/hudson/jobs/RAMSES_TEST/fr.tpt.aadl.ramses.junit.tests/tests/osek/osek-sonar-test/input
O_PATH ?= build
include /data/packages/nxtOSEK/ecrobot/ecrobot.mak
