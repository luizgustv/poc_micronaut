#!/bin/sh
set -e

unset http_proxy
unset https_proxy
unset HTTP_PROXY
unset HTTPS_PROXY
export no_proxy="localstack"
export NO_PROXY="localstack"

LOCALSTACK_HOST=localstack

waiting_resources(){
  resource=$1
  host=$2
  port=$3

  while ! nc -z $host $port; do
    echo "[INFO] - Waiting for resources ${resource} in ${host}:${port}..."
    sleep 1
  done
}

waiting_resources "Localstack" $LOCALSTACK_HOST 4566

echo "[INFO] - Waiting for ready resources..."
sleep 30

echo "[INFO] - Creating dynamodb table:"

#aws dynamodb create-table --endpoint-url http://$LOCALSTACK_HOST:4566 --cli-input-json file://client-table.json

echo "[INFO] - Resources created..."

tail /dev/stdout