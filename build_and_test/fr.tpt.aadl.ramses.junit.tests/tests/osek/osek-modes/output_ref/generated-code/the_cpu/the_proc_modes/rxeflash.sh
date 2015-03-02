echo Executing NeXTTool to upload the_proc_modes_OSEK.rxe...
wineconsole /cygdrive/C/cygwin/nexttool/NeXTTool.exe /COM=usb -download=the_proc_modes_OSEK.rxe
wineconsole /cygdrive/C/cygwin/nexttool/NeXTTool.exe /COM=usb -listfiles=the_proc_modes_OSEK.rxe
echo NeXTTool is terminated.
