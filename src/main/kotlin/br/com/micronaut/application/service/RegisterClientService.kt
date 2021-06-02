package br.com.micronaut.application.service

import br.com.micronaut.adapter.out.DynamoOperations
import br.com.micronaut.adapter.out.buildClientHash
import br.com.micronaut.application.domain.Client
import javax.inject.Singleton

@Singleton
class RegisterClientService(private val dynamo: DynamoOperations) {

    fun registerClient(client: Client): Client {
        dynamo.insertItem(buildClientHash(client.toEntity()), "DbClient")
        return client
    }

}