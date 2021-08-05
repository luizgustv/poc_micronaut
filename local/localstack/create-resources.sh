#!/bin/sh

LOCALSTACK_HOST=localstack

echo "[INFO] - Waiting for ready resources..."
sleep 10

echo "[INFO] - Creating dynamodb table:"

#comando para criar a tabela de acordo com o json
aws dynamodb create-table --endpoint-url http://$LOCALSTACK_HOST:4566 --cli-input-json file://client-table.json

echo "[INFO] - Resources created..."

tail /dev/stdout
