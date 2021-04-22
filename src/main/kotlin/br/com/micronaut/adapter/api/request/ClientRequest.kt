package br.com.micronaut.adapter.api.request

import br.com.micronaut.application.domain.Client
import br.com.micronaut.application.domain.ClientDocument
import java.util.*

class ClientRequest(
    private val clientId: String,
    private val name: String,
    private val document: String) {

    fun toDomain() = Client(this.clientId, this.name, ClientDocument(this.document))
}
