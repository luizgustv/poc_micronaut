package br.com.micronaut.config

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

class DynamoDbConfig {

    fun build(): DynamoDbClient =
        DynamoDbClient.builder()
            .region(Region.of("\${aws.region}"))
            .endpointOverride(URI("\${aws.endpoint}"))
            .build()


}