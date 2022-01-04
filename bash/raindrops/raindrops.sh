#!/usr/bin/env bash

set -e

usage () {
    >&2 echo "Usage: $0 <number>"
}

if [ "$#" -ne 1 ]; then
    usage
    exit 1
fi

result=""

[ $(($1%3)) -eq 0 ] && result="${result}Pling"
[ $(($1%5)) -eq 0 ] && result="${result}Plang"
[ $(($1%7)) -eq 0 ] && result="${result}Plong"
[ -z "$result" ] && result="$1"

echo "$result"
