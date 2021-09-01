package br.com.hartwig.integration.products.infrastructure.dataprovider.kafka.repository

import br.com.hartwig.commons.command.Repository
import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.kafka.client.KafkaClient
import java.util.UUID
import javax.inject.Singleton

@Singleton
class KafkaProductRepository(private val kafkaClient: KafkaClient) : Repository<Product> {
    override fun create(entity: Product): UUID? {
        kafkaClient.sendProduct(entity)
        return entity.id
    }

    override fun get(id: UUID): Product? {
        TODO("Not yet implemented")
    }

    override fun remove(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun list(): List<Product?> {
        TODO("Not yet implemented")
    }

    override fun update(entity: Product) {
        TODO("Not yet implemented")
    }
}
