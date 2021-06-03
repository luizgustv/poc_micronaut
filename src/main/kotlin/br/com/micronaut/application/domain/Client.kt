package br.com.micronaut.application.domain

import br.com.micronaut.adapter.out.entity.ClientEntity
import br.com.micronaut.application.exception.BusinessException
import br.com.micronaut.application.exception.ErrorReason
import javax.inject.Singleton

data class Client(
    val clientId: String,
    val name: String,
    val document: ClientDocument) {

    init {
        validateFields()
    }

    private fun validateFields() {

        val errors = mutableListOf<ErrorReason>()
        validateCLientId()?.let { errors.add(it) }
        validateName()?.let { errors.add(it) }
        validateDocument()?.let { errors.add(it) }

        if (errors.isNotEmpty()) throw BusinessException(errors)
    }

    private fun validateCLientId() : ErrorReason? =
        if (clientId.isBlank()) ErrorReason.REQUEST_EMPTY_CLIENT_ID else null

    private fun validateName() : ErrorReason? =
        if (name.isBlank()) ErrorReason.REQUEST_EMPTY_NAME else null

    private fun validateDocument() : ErrorReason? =
        if (document.value.isBlank()) ErrorReason.REQUEST_EMPTY_DOCUMENT else null

    //change?
    fun toEntity(): ClientEntity =
        ClientEntity(this.clientId, this.name, this.document.value)

}