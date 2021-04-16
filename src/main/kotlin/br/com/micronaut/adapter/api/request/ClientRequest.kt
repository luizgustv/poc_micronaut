package br.com.micronaut.adapter.api.request

import br.com.micronaut.application.domain.Client
import java.util.*

class ClientRequest(
    private val clientId: UUID,
    private val name: String,
    private val document: String) {

    fun toDomain() = Client(this.clientId, this.name, this.document)
}
