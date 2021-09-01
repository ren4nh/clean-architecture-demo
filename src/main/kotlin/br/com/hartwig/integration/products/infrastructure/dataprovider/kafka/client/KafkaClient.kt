package br.com.hartwig.integration.products.infrastructure.dataprovider.kafka.client

import br.com.hartwig.integration.products.core.domain.Product
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface KafkaClient {

    @Topic("create_product")
    fun sendProduct(product: Product)
}
