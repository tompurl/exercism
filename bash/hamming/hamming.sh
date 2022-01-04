#!/usr/bin/env bash

set -e

USAGE="Usage: $0 <string1> <string2>"

die () {
    >&2 echo "$1"
    exit 1
}

print_hamming_distance () {
    counter=0
    for (( i=0; i<${#1}; i++ )); do
        [[ "${1:$i:1}" != "${2:$i:1}" ]] && ((counter+=1))
    done
    echo "$counter"
}

# sanity check
[ "$#" -ne 2 ] && die "$USAGE"
[ "${#1}" -ne "${#2}" ] && die "strands must be of equal length"

# main
[[ "$1" == "$2" ]] && echo 0 && exit 0
print_hamming_distance "$1" "$2"
