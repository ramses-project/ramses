var=`echo $TRAMPOLINEPATH | sed 's/\//\\\\\//g'`
sed -i.old 's/TRAMPOLINE\_BASE\_PATH =/TRAMPOLINE\_BASE\_PATH = \"'$var'\";/' $1
