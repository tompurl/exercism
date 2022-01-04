#!/usr/bin/env bash

usage () {
    >&2 echo "Usage: error_handling.sh <person>"
}

if [ "$#" -ne 1 ]; then
    usage
    exit 1
fi

echo "Hello, $1"
