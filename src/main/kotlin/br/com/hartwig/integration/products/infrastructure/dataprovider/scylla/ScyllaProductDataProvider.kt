package br.com.hartwig.integration.products.infrastructure.dataprovider.scylla

import br.com.hartwig.integration.products.core.dataprovider.ProductDataProvider
import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.scylla.repository.ScyllaProductRepository
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import java.util.UUID
import javax.inject.Singleton

@Singleton
@Primary
class ScyllaProductDataProvider(private val productRepository: ScyllaProductRepository) : ProductDataProvider {

    override fun create(product: Product): UUID? {
        return productRepository.create(product)
    }
}
