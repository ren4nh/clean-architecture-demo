package br.com.hartwig.integration.products.infrastructure.dataprovider.api

import br.com.hartwig.integration.products.core.dataprovider.ProductDataProvider
import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.api.repository.ApiProductRepository
import io.micronaut.context.annotation.Requires
import java.util.UUID
import javax.inject.Singleton

@Singleton
@Requires(property = "dataprovider", value = "api")
class ApiProductDataProvider(private val productRepository: ApiProductRepository) : ProductDataProvider {

    override fun create(product: Product): UUID? {
        return productRepository.create(product)
    }
}
