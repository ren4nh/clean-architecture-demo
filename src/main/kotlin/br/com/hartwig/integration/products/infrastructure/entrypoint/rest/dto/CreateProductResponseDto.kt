package br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto

import br.com.hartwig.integration.products.core.interactor.create.CreateProductResponse
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal

@Introspected
data class CreateProductResponseDto(
    var id: String,
    var sku: String,
    var name: String,
    var price: BigDecimal,
    var color: String?
)

fun CreateProductResponse.toDto() = CreateProductResponseDto(id, sku, name, price, color)
