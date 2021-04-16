package br.com.micronaut.application.domain

import java.util.*

data class Client(
    val clientId: UUID,
    val name: String,
    val document: String
) {
}