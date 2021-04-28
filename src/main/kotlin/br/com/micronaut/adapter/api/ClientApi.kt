package br.com.micronaut.adapter.api

import br.com.micronaut.adapter.api.request.ClientRequest
import br.com.micronaut.adapter.api.response.ClientResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

interface ClientApi {

    @Get("/test")
    fun testApi(): String

    @Post("/client")
    fun registerClient(@Body request: ClientRequest): HttpResponse<ClientResponse>

    @Get("/client/{clientId}")
    fun findDocument(@PathVariable("clientId") request: String): Map<String, String>

}