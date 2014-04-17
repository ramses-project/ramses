rule_count=0;
lazyrule_count=0;
uniquelazyrule_count=0;

for file in $(grep -lir '^rule ' * | grep .atl$); do
     temp_rule=`grep -o ^rule "$file" | wc -w`; rule_count=$((rule_count+temp_rule));
     temp_ulzrule=`grep -o ^unique lazy rule "$file" | wc -w`; uniquelazyrule_count=$((uniquelazyrule_count+temp_ulzrule));
     temp_lzrule=`grep -o ^lazy rule "$file" | wc -w`; lazyrule_count=$((lazyrule_count+temp_lzrule));
     echo "in $file, found $temp_rule rules; $temp_ulzrule unique lazy rules; $temp_lzrule lazy rules";
done;

echo "The set of atl files contain $rule_count matched rules; $uniquelazyrule_count unique lazy rule; $lazyrule_count lazy rules";