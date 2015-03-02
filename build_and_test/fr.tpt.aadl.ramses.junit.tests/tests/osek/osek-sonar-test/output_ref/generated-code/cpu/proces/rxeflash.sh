echo Executing NeXTTool to upload proces_OSEK.rxe...
wineconsole /cygdrive/C/cygwin/nexttool/NeXTTool.exe /COM=usb -download=proces_OSEK.rxe
wineconsole /cygdrive/C/cygwin/nexttool/NeXTTool.exe /COM=usb -listfiles=proces_OSEK.rxe
echo NeXTTool is terminated.
