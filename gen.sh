#!/bin/bash
set -eu

rm README.md || true

problemset=()
solvedset=()
while read -r line; do
  problemset+=("$line")
  solvedset+=("")
done < <(jq -c '.[]' LeetCodeProblemSet_simplified.json)

for dir in src/[A-Z]/*_*; do
  id=$(echo $dir | cut -d '_' -f2)
  solstr=""
  i=0
  for sol in $dir/*[1-4].java; do
    ((i = i + 1))
    solstr+="[Solution$i]($sol) <br>"
    solstr+=$(grep '\$\$' $sol | cut -d ' ' -f4- | tr --delete '\r' | awk '{print}' ORS='<br>')
  done
  problem="${problemset[id-1]}"
  link=$(jq --raw-output '"[\(.title)](\(.url))"' <<< "$problem")
  solvedset[id]="| $id | $link | $solstr |"
done

count=0
for line in "${solvedset[@]}"; do
  [[ -n "$line" ]] && ((count++)) || true
done

cat <<EOF > README.md
## ${count} problems with solutions
| ID | Name | Solutions |
| --- | --- | --- |
EOF

for line in "${solvedset[@]}"; do
  [[ -n "$line" ]] && echo "$line" >> README.md
done
