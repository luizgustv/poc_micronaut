package br.com.micronaut.application.exception

enum class ErrorReason(val key: String, val message: String) {

    REQUEST_EMPTY_NAME("REQUEST_EMPTY_NAME","Name cannot be null or empty"),
    REQUEST_EMPTY_CLIENT_ID("REQUEST_EMPTY_CLIENT_ID","ClientId cannot be null or empty"),
    REQUEST_EMPTY_DOCUMENT("REQUEST_EMPTY_DOCUMENT","Document cannot be null or empty");

}