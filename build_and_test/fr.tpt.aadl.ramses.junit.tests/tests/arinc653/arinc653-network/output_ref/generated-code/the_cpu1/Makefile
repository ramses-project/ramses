export ARCH=x86
MAC_ADDR=00:1F:C6:BF:74:06
QEMU_NETWORK_MODE=listen
export BSP=x86-qemu
export POK_CONFIG_OPTIMIZE_FOR_GENERATED_CODE=1
include $(POK_PATH)/misc/mk/config.mk
include $(POK_PATH)/misc/mk/common-$(ARCH).mk
TARGET=$(shell pwd)/pok.elf
PARTITIONS=the_cpu1_system_part_comProcess/the_cpu1_system_part_comProcess.elf the_proc1/the_proc1.elf 
KERNEL=kernel/kernel.lo
all: build-kernel partitions $(TARGET)
build-kernel:
	$(CD) kernel && $(MAKE)
partitions:
	$(CD) the_cpu1_system_part_comProcess && $(MAKE)
	$(CD) the_proc1 && $(MAKE)
clean: common-clean
	$(CD) kernel && $(MAKE) clean
	$(CD) the_cpu1_system_part_comProcess && $(MAKE) clean
	$(CD) the_proc1 && $(MAKE) clean
distclean: clean
	$(CD) kernel && $(MAKE) distclean
	$(CD) the_cpu1_system_part_comProcess && $(MAKE) distclean
	$(CD) the_proc1 && $(MAKE) distclean
include $(POK_PATH)/misc/mk/rules-common.mk
include $(POK_PATH)/misc/mk/rules-main.mk
include $(POK_PATH)/misc/mk/install-rules.mk
