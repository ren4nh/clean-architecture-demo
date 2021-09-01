package br.com.hartwig.integration.products.infrastructure.dataprovider.kafka

import br.com.hartwig.integration.products.core.dataprovider.ProductDataProvider
import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.kafka.repository.KafkaProductRepository
import io.micronaut.context.annotation.Primary
import java.util.UUID
import javax.inject.Singleton

@Singleton
@Primary
class KafkaProductDataProvider(private val productRepository: KafkaProductRepository) : ProductDataProvider {

    override fun create(product: Product): UUID? {
        return productRepository.create(product)
    }
}
