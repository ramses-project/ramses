
nexttool_path=/home/castella/tools/lego-nxt-tools_x86_64-unknown-linux-gnu/nexttool


all:
	 make -C generated-code all
clean:
	 make -C generated-code clean
deploy:
	 sudo  $(nexttool_path) /COM=usb -download=generated-code/cpu/proces/proces_OSEK.rxe

