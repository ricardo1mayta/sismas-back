#!/bin/bash

# creando directorios temporales
systemctl status docker.service
#/usr/local/bin/docker-compose -f /apps/becacloud/docker-compose.yml down 
nohup /usr/local/bin/docker-compose -f /apps/becacloud/docker-compose.yml up > /dev/null 2>&1 &
