package br.com.hartwig.integration.products.infrastructure.dataprovider.nats

import br.com.hartwig.integration.products.core.dataprovider.ProductDataProvider
import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.nats.repository.NatsProductRepository
import java.util.UUID
import javax.inject.Singleton

@Singleton
class NatsProductDataProvider(private val productRepository: NatsProductRepository) : ProductDataProvider {

    override fun create(product: Product): UUID? {
        return productRepository.create(product)
    }
}
