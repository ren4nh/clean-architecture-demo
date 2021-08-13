package br.com.hartwig.integration.products.infrastructure.dataprovider.nats.client

import br.com.hartwig.integration.products.core.domain.Product
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface NatsClient {

    @Subject("create_product")
    fun sendProduct(product: Product)
}
