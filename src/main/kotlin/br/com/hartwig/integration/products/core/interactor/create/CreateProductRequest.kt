package br.com.hartwig.integration.products.core.interactor.create

import br.com.hartwig.integration.products.core.domain.Product
import java.math.BigDecimal
import java.util.UUID

data class CreateProductRequest(
    val sku: String,
    val name: String,
    val price: BigDecimal,
    val color: String?
) {
    internal fun toProduct() = Product(id = UUID.randomUUID(), sku, name, price, color)
}
