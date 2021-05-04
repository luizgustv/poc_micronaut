package br.com.micronaut.adapter.controller

import br.com.micronaut.adapter.api.ClientApi
import br.com.micronaut.adapter.api.request.ClientRequest
import br.com.micronaut.adapter.api.response.ClientResponse
import br.com.micronaut.adapter.api.response.FindDocumentResponse
import br.com.micronaut.application.service.FindDocumentService
import br.com.micronaut.application.service.RegisterClientService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller

@Controller("/micronaut/v1")
class ClientController(private val registerClientService: RegisterClientService, private val findDocumentService: FindDocumentService) : ClientApi {

    override fun testApi(): String = "Hello testing..."

    override fun registerClient(request: ClientRequest): HttpResponse<ClientResponse> {
        val response = registerClientService.registerClient(request.toDomain())
        return HttpResponse.ok(ClientResponse(response))
    }

    override fun findDocument(clientId: String): HttpResponse<FindDocumentResponse> {
        val response = findDocumentService.findDocument(clientId)
        return HttpResponse.ok(FindDocumentResponse(response))
    }

}