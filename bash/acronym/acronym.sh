#!/usr/bin/env bash

set -e

USAGE="Usage: $0 <phrase>"

die () {
    >&2 echo "$1"
    exit 1
}

# sanity check
[ "$#" -ne 1 ] && die "$USAGE"

# Replace chars that aren't what we want with a space
words="${1//[!a-zA-Z \']/ }"

# Read resulting space-delimited string into an array
read -ra words_arr <<< "$words"

letters=""
for idx in "${!words_arr[@]}"; do
    # Add first char of each array element to letters
    letters="${letters}${words_arr[idx]:0:1}"
done

echo "${letters^^}"
