package br.com.micronaut.application.domain

import br.com.micronaut.application.exception.BusinessException
import javax.inject.Singleton

@Singleton
data class Client(
    val clientId: String,
    val name: String,
    val document: ClientDocument) {

    init {
        validateFields()
    }

    private fun validateFields() {

        if (this.clientId.isBlank()) {
            throw BusinessException("The clientId must not be empty")
        }
        if (this.name.isBlank()) {
            throw BusinessException("The name must not be empty")
        }
        if (this.document.value.isBlank()) {
            throw BusinessException("The document must not be empty")
        }

    }


}