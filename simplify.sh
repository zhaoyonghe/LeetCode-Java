#!/bin/bash
set -euo pipefail

jq '.stat_status_pairs[].stat | {id:.frontend_question_id,title:.question__title, url:("https://leetcode.com/problems/"+.question__title_slug)}' < LeetCodeProblemSet.json | jq --slurp '. | sort_by(.id)' > LeetCodeProblemSet_simplified.json
