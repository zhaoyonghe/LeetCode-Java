#!/bin/bash
set -euo pipefail

jq 'to_entries | all(.key == (.value.id - 1))' LeetCodeProblemSet_simplified.json