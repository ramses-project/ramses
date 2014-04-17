export ARCH=x86
export BSP=x86-qemu
export POK_CONFIG_OPTIMIZE_FOR_GENERATED_CODE=1
include $(POK_PATH)/misc/mk/config.mk
include $(POK_PATH)/misc/mk/common-$(ARCH).mk
TARGET=$(shell pwd)/pok.elf
PARTITIONS=S1_inst/S1_inst.elf S2_inst/S2_inst.elf 
KERNEL=kernel/kernel.lo
all: build-kernel partitions $(TARGET)
build-kernel:
	$(CD) kernel && $(MAKE)
partitions:
	$(CD) S1_inst && $(MAKE)
	$(CD) S2_inst && $(MAKE)
clean: common-clean
	$(CD) kernel && $(MAKE) clean
	$(CD) S1_inst && $(MAKE) clean
	$(CD) S2_inst && $(MAKE) clean
distclean: clean
	$(CD) kernel && $(MAKE) distclean
	$(CD) S1_inst && $(MAKE) distclean
	$(CD) S2_inst && $(MAKE) distclean
include $(POK_PATH)/misc/mk/rules-common.mk
include $(POK_PATH)/misc/mk/rules-main.mk
include $(POK_PATH)/misc/mk/install-rules.mk
