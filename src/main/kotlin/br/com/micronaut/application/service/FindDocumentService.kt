package br.com.micronaut.application.service

import br.com.micronaut.application.domain.Client
import br.com.micronaut.application.domain.ClientDocument
import javax.inject.Singleton

@Singleton
class FindDocumentService {

    fun findDocument(clientId: String): Client{
        return Client("dasjkdl","Luiz", ClientDocument("58934058324"))
    }

}