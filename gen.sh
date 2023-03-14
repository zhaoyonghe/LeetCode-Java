#!/bin/bash
set -eu

rm README.md || true
cat <<EOF > README.md
| ID | Name | Solutions |
| --- | --- | --- |
EOF

for dir in src/*_*; do
  id=$(echo $dir | cut -d '_' -f2)
  solstr=""
  i=0
  for sol in $dir/*[1-4].java; do
    ((i = i + 1))
    solstr+="[Solution$i]($sol) <br>"
    solstr+=$(grep '\$\$' $sol | cut -d ' ' -f4- | tr --delete '\r' | awk '{print}' ORS='<br>')
  done
  jq --raw-output --arg id "$id" --arg solstr "$solstr" '.[($id | tonumber - 1)] | "| \(.id) | [\(.title)](\(.url)) | \($solstr) |"' LeetCodeProblemSet_simplified.json >> README.md
done