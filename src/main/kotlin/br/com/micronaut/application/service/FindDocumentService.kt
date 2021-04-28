package br.com.micronaut.application.service

import javax.inject.Singleton

@Singleton
class FindDocumentService {

    fun findDocument(clientId: String): String{
        return "43857348974"
    }

}