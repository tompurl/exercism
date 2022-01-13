#!/usr/bin/env bash

set -e

USAGE="Usage: $0 <phrase>"

die () {
    >&2 echo "$1"
    exit 1
}

# sanity check
[ "$#" -ne 1 ] && die "$USAGE"

declare -A character_dict
character_dict["a"]=0
character_dict["b"]=0
character_dict["c"]=0
character_dict["d"]=0
chnaracter_dict["e"]=0
character_dict["f"]=0
character_dict["g"]=0
character_dict["h"]=0
character_dict["i"]=0
character_dict["j"]=0
character_dict["k"]=0
character_dict["l"]=0
character_dict["m"]=0
character_dict["n"]=0
character_dict["o"]=0
character_dict["p"]=0
character_dict["q"]=0
character_dict["r"]=0
character_dict["s"]=0
character_dict["t"]=0
character_dict["u"]=0
character_dict["v"]=0
character_dict["w"]=0
character_dict["x"]=0
character_dict["y"]=0
character_dict["z"]=0

# Remove spaces and special characters
input_string="${1//[!a-zA-Z]/}"

# Make all letters lower-case
input_string="${input_string,,}"

# Loop over every character in the phrase
for (( i=0; i<${#input_string}; i++ )); do
    # Grab the char
    char="${input_string:$i:1}"
    # Increment the number of times we've seen that char
    character_dict[$char]=$((character_dict[$char]+1))

    # If it's more than once then this is not a pangram
    if [[ ${character_dict[$char]} -gt 1 ]]; then
        echo false
        exit 0
    fi
done

# Now loop over each key in the dictionary and see if the value is still 0
for key in "${!character_dict[@]}"; do
    if [[ ${character_dict[$key]} -eq 0 ]]; then
        echo false
        exit 0
    fi
done

# Hooray! One of each letter
echo true
