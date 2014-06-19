export POK_PATH=/usr/share/pok
all:
	$(MAKE) -C root_inst all

clean:
	$(MAKE) -C root_inst clean

run:
	$(MAKE) -C root_inst run

test:
	$(MAKE) -C root_inst run QEMU_MISC="-nographic -serial /dev/stdout > root_inst.trace"
