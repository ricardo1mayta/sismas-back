#!/bin/bash

rm -rf /apps/becacloud/cloud/sigmaweb/*

#agregando
# nuevo comando
docker container stop sigma-web-v1 || true
docker container rm sigma-web-v1 || true
docker rmi -f $(docker images | grep "<none>" | awk "{print \$3}") || true