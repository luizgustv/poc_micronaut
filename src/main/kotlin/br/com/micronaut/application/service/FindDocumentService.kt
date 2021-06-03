package br.com.micronaut.application.service

import br.com.micronaut.adapter.out.DynamoOperations
import br.com.micronaut.application.domain.Client
import javax.inject.Singleton

@Singleton
class FindDocumentService(private val dynamo: DynamoOperations) {

    fun findDocument(clientId: String): Client {
        return dynamo.findItem(clientId, "DbClient").toDomain()
    }

}