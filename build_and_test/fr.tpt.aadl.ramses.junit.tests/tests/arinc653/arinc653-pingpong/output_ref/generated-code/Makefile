export POK_PATH=/usr/share/pok
all:
	$(MAKE) -C node_1_inst all

clean:
	$(MAKE) -C node_1_inst clean

run:
	$(MAKE) -C node_1_inst run

test:
	$(MAKE) -C node_1_inst run QEMU_MISC="-nographic -serial /dev/stdout > node_1_inst.trace"