package br.com.micronaut.application.service

import br.com.micronaut.config.DynamoDbConfig
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType
import javax.inject.Singleton

@Singleton
class DatabaseOperations(private val db: DynamoDbConfig) {

    fun createTable(){
        db.build().createTable {
            CreateTableRequest.builder()
                .attributeDefinitions(
                    AttributeDefinition.builder()
                        .attributeName("key")
                        .attributeType(ScalarAttributeType.S)
                        .build()
                ).build()
        }
    }

}