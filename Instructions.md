# How to get [LeetCodeProblemSet.json](LeetCodeProblemSet.json)
```shell
curl -s https://leetcode.com/api/problems/all/
```
# Convert
```shell
cat LeetCodeProblemSet.json | jq '.stat_status_pairs[].stat | {id:.frontend_question_id,title:.question__title, url:("https://leetcode.com/problems/"+.question__title_slug)}' | jq --slurp '. | sort_by(.id)' > LeetCodeProblemSet_simplified.json
```