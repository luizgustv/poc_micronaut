package br.com.micronaut.config

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

class DynamoDbConfig {

    fun build(): DynamoDbClient =
        DynamoDbClient.builder()
            .credentialsProvider(StaticCredentialsProvider.create(buildAwsCredentials()))
            .region(Region.of("\${aws.region}"))
            .endpointOverride(URI("\${aws.endpoint}"))
            .build()

    private fun buildAwsCredentials() = AwsBasicCredentials.create("\${aws.accessKeyId}","\${aws.secretKey}")
}