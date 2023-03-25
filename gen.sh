#!/bin/bash
set -eu

rm README.md || true
cat <<EOF > README.md
| ID | Name | Solutions |
| --- | --- | --- |
EOF

array=()
while read -r line; do
  array+=("$line")
done < <(jq -c '.[]' LeetCodeProblemSet_simplified.json)

for dir in src/*_*; do
  id=$(echo $dir | cut -d '_' -f2)
  solstr=""
  i=0
  for sol in $dir/*[1-4].java; do
    ((i = i + 1))
    solstr+="[Solution$i]($sol) <br>"
    solstr+=$(grep '\$\$' $sol | cut -d ' ' -f4- | tr --delete '\r' | awk '{print}' ORS='<br>')
  done
  problem="${array[id-1]}"
  link=$(jq --raw-output '"[\(.title)](\(.url))"' <<< "$problem")
  echo "| $id | $link | $solstr |" >> README.md
done