package br.com.micronaut.application.service

import br.com.micronaut.application.domain.Client
import javax.inject.Singleton

@Singleton
class RegisterClientService {

    fun registerClient(client: Client): Client {
        return client
    }

}