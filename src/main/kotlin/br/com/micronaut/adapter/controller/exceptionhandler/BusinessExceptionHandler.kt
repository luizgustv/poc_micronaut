package br.com.micronaut.adapter.controller.exceptionhandler

import br.com.micronaut.application.exception.BusinessException
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.simple.SimpleHttpResponseFactory
import javax.inject.Singleton

@Produces
@Singleton
@Requirements(Requires(classes = [BusinessException::class]))
class BusinessExceptionHandler :
    ExceptionHandler<BusinessException, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>, exception: BusinessException): HttpResponse<ErrorResponse> {
        return SimpleHttpResponseFactory.INSTANCE
            .status(HttpStatus.UNPROCESSABLE_ENTITY,
                ErrorResponse(exception.errors.map { Error(it.key, it.message) }
                )
            )
    }
}