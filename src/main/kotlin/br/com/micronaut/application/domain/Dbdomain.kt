package br.com.micronaut.application.domain

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable


@DynamoDBTable(tableName = "DbClient")
class Dbdomain(
    @DynamoDBHashKey(attributeName = "clientId")
    val clientId: String,
    @DynamoDBAttribute(attributeName = "name")
    val name: String,
    @DynamoDBAttribute(attributeName = "document")
    val document: ClientDocument
)