package br.com.micronaut.application.exception

import java.lang.Exception

open class BaseException(val errors : List<ErrorReason>) : Exception() {

    constructor(errorReason : ErrorReason) : this(listOf(errorReason))
}