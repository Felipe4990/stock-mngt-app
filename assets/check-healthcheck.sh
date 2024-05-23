#!/bin/bash

while (true); do
    HEALTH=`curl --max-time 1 -s http://localhost:8080/actuator/health  | grep -Po '"status": *\K"[^"]*"'`
    if [[ -n "$HEALTH" ]]; then
        if [ $HEALTH != "OK" ]; then
            echo "## Health OK"
            break
        fi
    fi
done