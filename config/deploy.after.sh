#!/bin/bash

# creando directorios temporales
systemctl status docker.service

#agregando
cd /apps/becacloud/cloud/sigmaweb/ && docker build -t sigma-web-v1 --build-arg environment=prod --no-cache .
docker run -d --name sigma-web-v1 -p 8020:8020 sigma-web-v1:latest
