#!/bin/sh

LOCALSTACK_HOST=localstack

#waiting_resources() {
#  resource=$1
#  host=$2
#  port=$3
#  while ! nc -z $host $port; do
#    echo "[INFO] - Waiting for resources ${resource} in ${host}:${port}..."
#    sleep 1
#  done
#}

waiting_resources "Localstack" $LOCALSTACK_HOST 4566

echo "[INFO] - Waiting for ready resources..."
sleep 10

echo "[INFO] - Creating dynamodb table:"

aws dynamodb create-table --endpoint-url http://$LOCALSTACK_HOST:4566 --cli-input-json file://client-table.json

echo "[INFO] - Resources created..."

tail /dev/stdout
