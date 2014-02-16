#!/usr/bin/env sh
echo "Current directory is $(pwd)"
echo "\n=== ERROR REPORTS ===\n"

for F in build/reports/tests/*.html
do
    echo $F
    cat $F
    echo "----------------------"
    echo
done

echo
echo
echo "\n=== TEST RESULTS ===\n"

for F in build/test-results/*.xml
do
    echo $F
    cat $F
    echo "----------------------"
    echo
done



