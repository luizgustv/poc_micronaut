package br.com.micronaut.adapter.out

import br.com.micronaut.adapter.out.entity.ClientEntity
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest


fun buildClientHash(client: ClientEntity): HashMap<String, AttributeValue> {
    val itemValues = HashMap<String, AttributeValue>()

    itemValues.apply {
        this["clientId"] = AttributeValue.builder().s(client.clientId).build()
        this["name"] = AttributeValue.builder().s(client.name).build()
        this["document"] = AttributeValue.builder().s(client.document).build()
    }
    return itemValues
}

fun buildClientItemRequest(value: String, tableName: String): GetItemRequest {

    val keyToGet = HashMap<String, AttributeValue>()
    keyToGet["clientId"] = AttributeValue.builder().s(value).build()

    return GetItemRequest.builder()
        .key(keyToGet)
        .tableName(tableName)
        .build()
}

fun buildClientEntity(itemsFound: Map<String, AttributeValue>): ClientEntity =
    itemsFound.run {
        ClientEntity(this["clientId"]?.s(), this["name"]?.s(), this["document"]?.s())
    }
