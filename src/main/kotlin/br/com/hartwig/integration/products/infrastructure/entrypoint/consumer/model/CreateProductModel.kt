package br.com.hartwig.integration.products.infrastructure.entrypoint.consumer.model

import br.com.hartwig.integration.products.core.interactor.create.CreateProductRequest
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal

@Introspected
data class CreateProductModel(
    var id: String?,
    var sku: String,
    var name: String,
    var price: BigDecimal,
    var color: String?
)

fun CreateProductModel.toRequest() = CreateProductRequest(sku, name, price, color)
