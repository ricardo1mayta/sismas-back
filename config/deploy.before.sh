#!/bin/bash

rm -rf /apps/becacloud/cloud/sigmaweb
mkdir /apps/becacloud/cloud/sigmaweb
#Parando el Servicio
/usr/local/bin/docker-compose -f /apps/becacloud/docker-compose.yml down