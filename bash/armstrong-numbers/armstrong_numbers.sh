#!/usr/bin/env bash

set -e

USAGE="Usage: $0 <number>"

die () {
    >&2 echo "$1"
    exit 1
}

# sanity check
[ "$#" -ne 1 ] && die "$USAGE"

exponent=${#1}
total_sum=0

for digit in $(fold -w1 <<< "$1"); do
	intermediate_sum=$((digit**exponent))
	total_sum=$((total_sum+intermediate_sum))
done

if [ "$1" -ne "$total_sum" ]; then
	echo false
else
	echo true
fi
