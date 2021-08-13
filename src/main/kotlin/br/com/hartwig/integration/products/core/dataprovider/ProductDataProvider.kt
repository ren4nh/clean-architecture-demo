package br.com.hartwig.integration.products.core.dataprovider

import br.com.hartwig.integration.products.core.domain.Product
import java.util.UUID

interface ProductDataProvider {
    fun create(product: Product): UUID?
}
