count=0;

for file in $(grep -lir '^rule ' * | grep .atl$); do
     temp=`grep -o ^rule "$file" | wc -w`; count=$((count+temp)); 
     echo "in $file, found $temp rules";
done;

echo "the set of atl files contain $count rules";