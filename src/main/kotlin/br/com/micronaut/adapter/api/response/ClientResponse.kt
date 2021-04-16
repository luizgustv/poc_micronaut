package br.com.micronaut.adapter.api.response

import br.com.micronaut.application.domain.Client
import java.util.*

class ClientResponse(
    val clientId: UUID,
    val name: String,
    val document: String
) {
    constructor(client: Client) : this(client.clientId, client.name, client.document)
}


