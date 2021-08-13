package br.com.hartwig.integration.products.core.interactor.create

import java.math.BigDecimal

data class CreateProductResponse(
    val id: String,
    val sku: String,
    val name: String,
    val price: BigDecimal,
    val color: String?
)
