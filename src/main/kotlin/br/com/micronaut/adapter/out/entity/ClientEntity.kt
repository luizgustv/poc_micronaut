package br.com.micronaut.adapter.out.entity

import br.com.micronaut.application.domain.ClientDocument

class ClientEntity(
    val clientId: String,
    val name: String,
    val document: ClientDocument
) {
}