package br.com.hartwig.integration.products.infrastructure.entrypoint.consumer

import br.com.hartwig.commons.log.AppLogger
import br.com.hartwig.integration.products.core.interactor.create.CreateProductInteractor
import br.com.hartwig.integration.products.infrastructure.entrypoint.consumer.model.CreateProductModel
import br.com.hartwig.integration.products.infrastructure.entrypoint.consumer.model.toRequest
import io.micronaut.context.annotation.Requires
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
@Requires(property = "nats.enabled", value = "true")
class CreateProductListener(private val createProductInteractor: CreateProductInteractor) {

    @Subject("create_product_request")
    fun create(model: CreateProductModel) {
        try {
            createProductInteractor.create(model.toRequest())
        } catch (e: Exception) {
            AppLogger.logger.error(e.message, e)
        }
    }
}
