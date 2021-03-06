package br.com.micronaut.adapter.out

import br.com.micronaut.adapter.out.entity.ClientEntity
import io.micronaut.context.annotation.Value
import io.micronaut.context.event.StartupEvent
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.exceptions.HttpException
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.*
import java.lang.Exception
import java.net.URI
import javax.inject.Singleton


@Singleton
class DynamoOperations(
    @Value("\${aws.region}")
    private var awsRegion: String,
    @Value("\${aws.endpoint}")
    private var awsDynamoEndpoint: String
) {

    companion object {
        private val logger = LoggerFactory.getLogger(DynamoOperations::class.java)
    }

    private fun buildDbClient(): DynamoDbClient =
        DynamoDbClient.builder()
            .credentialsProvider(StaticCredentialsProvider.create(buildAwsCredentials()))
            .region(Region.of(awsRegion))
            .endpointOverride(URI(awsDynamoEndpoint))
            .build()

    private fun buildAwsCredentials() = AwsBasicCredentials.create("\${aws.accessKeyId}", "\${aws.secretKey}")

    //@EventListener
    fun createTable(startupEvent: StartupEvent) {

        val tables = buildDbClient().listTables()

        if (!tables.tableNames().contains("DbClient")) {
            val request: CreateTableRequest = CreateTableRequest.builder()
                .attributeDefinitions(
                    AttributeDefinition.builder()
                        .attributeName("clientId")
                        .attributeType(ScalarAttributeType.S)
                        .build()
                )
                .keySchema(
                    KeySchemaElement.builder()
                        .attributeName("clientId")
                        .keyType(KeyType.HASH)
                        .build()
                )
                .provisionedThroughput(
                    ProvisionedThroughput.builder()
                        .readCapacityUnits(10)
                        .writeCapacityUnits(10)
                        .build()
                )
                .tableName("DbClient")
                .build()

            buildDbClient().createTable(request)
        }

    }

    fun insertItem(itemValues: HashMap<String, AttributeValue>, tableName: String) {

        val putItemRequest = PutItemRequest.builder()
            .tableName(tableName)
            .item(itemValues)
            .build()

        try {
            buildDbClient().putItem(putItemRequest)
            logger.info("item adicionado no dynamo")
        } catch (ex: ResourceNotFoundException) {
            logger.info("Tabela n??o encontrada")
        } catch (ex: DynamoDbException) {
            logger.error(ex.message)
        }

    }

    fun findItem(value: String, tableName: String): ClientEntity {

        val itemRequest = buildClientItemRequest(value, tableName)

        try {
            val itemsFound = buildDbClient().getItem(itemRequest).item()

            if (itemsFound.isEmpty())
                throw HttpClientResponseException("Item n??o encontrado", HttpResponse.notFound(""))

            return buildClientEntity(itemsFound)

        } catch (ex: DynamoDbException) {
            logger.error(ex.message)
            throw Exception("erro no banco!")
        }
    }

}