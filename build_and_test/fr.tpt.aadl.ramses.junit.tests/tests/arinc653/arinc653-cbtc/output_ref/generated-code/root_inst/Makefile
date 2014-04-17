export ARCH=x86
export BSP=x86-qemu
export POK_CONFIG_OPTIMIZE_FOR_GENERATED_CODE=1
include $(POK_PATH)/misc/mk/config.mk
include $(POK_PATH)/misc/mk/common-$(ARCH).mk
TARGET=$(shell pwd)/pok.elf
PARTITIONS=train_inst/train_inst.elf railway_inst/railway_inst.elf 
KERNEL=kernel/kernel.lo
all: build-kernel partitions $(TARGET)
build-kernel:
	$(CD) kernel && $(MAKE)
partitions:
	$(CD) train_inst && $(MAKE)
	$(CD) railway_inst && $(MAKE)
clean: common-clean
	$(CD) kernel && $(MAKE) clean
	$(CD) train_inst && $(MAKE) clean
	$(CD) railway_inst && $(MAKE) clean
distclean: clean
	$(CD) kernel && $(MAKE) distclean
	$(CD) train_inst && $(MAKE) distclean
	$(CD) railway_inst && $(MAKE) distclean
include $(POK_PATH)/misc/mk/rules-common.mk
include $(POK_PATH)/misc/mk/rules-main.mk
include $(POK_PATH)/misc/mk/install-rules.mk
