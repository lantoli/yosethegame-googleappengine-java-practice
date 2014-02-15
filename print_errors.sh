#!/usr/bin/env sh
echo "Current directory is $(pwd)"
echo "\n=== LIST ===\n"
ls -la build/reports/tests
echo "\n=== ERROR REPORTS ===\n"

for F in build/reports/tests/*
do
    echo $F
    cat $F
    echo
done

#    - "cat build/reports/tests/index.html"


