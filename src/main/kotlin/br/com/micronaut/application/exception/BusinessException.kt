package br.com.micronaut.application.exception

class BusinessException : BaseException {

    constructor(errorReason: ErrorReason) : super(errorReason)

    constructor(errorReasons: List<ErrorReason>) : super(errorReasons)

}