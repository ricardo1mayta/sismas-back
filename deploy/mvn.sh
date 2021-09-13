#!/bin/bash

echo "****************"
echo "* Building jar!*"
echo "****************"

docker run -u $(id -u) --rm -v /var/lib/jenkins/.m2:/root/.m2 -v $WORKSPACE/app/:/app -w /app maven:3-alpine "$@"
