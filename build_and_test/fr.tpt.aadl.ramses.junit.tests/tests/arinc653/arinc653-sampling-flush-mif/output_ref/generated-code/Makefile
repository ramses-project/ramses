export POK_PATH=/usr/share/pok
all:
	$(MAKE) -C the_cpu all

clean:
	$(MAKE) -C the_cpu clean

run:
	$(MAKE) -C the_cpu run

test:
	$(MAKE) -C the_cpu run QEMU_MISC="-nographic -serial /dev/stdout > the_cpu.trace"
