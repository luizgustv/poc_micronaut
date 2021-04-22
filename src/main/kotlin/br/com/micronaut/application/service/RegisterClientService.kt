package br.com.micronaut.application.service

import br.com.micronaut.application.domain.Client
import javax.inject.Singleton

@Singleton
class RegisterClientService {

    fun registerClient(client: Client): Client {

        //validar campo clientid nome e documento


        return client
    }

}