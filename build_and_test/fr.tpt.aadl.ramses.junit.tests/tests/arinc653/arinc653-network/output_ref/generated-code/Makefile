export POK_PATH=/usr/share/pok

all:
	$(MAKE) -C the_cpu1 all
	$(MAKE) -C the_cpu2 all

clean:
	$(MAKE) -C the_cpu1 clean
	$(MAKE) -C the_cpu2 clean

run:
	$(MAKE) -C the_cpu1 run
	$(MAKE) -C the_cpu2 run

test:
	$(MAKE) -C the_cpu1 run QEMU_MISC="-nographic -serial /dev/stdout > the_cpu1.trace"
	$(MAKE) -C the_cpu2 run QEMU_MISC="-nographic -serial /dev/stdout > the_cpu2.trace"
