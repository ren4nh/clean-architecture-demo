package br.com.hartwig.integration.products.infrastructure.dataprovider.nats.repository

import br.com.hartwig.commons.command.Repository
import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.nats.client.NatsClient
import java.util.UUID
import javax.inject.Singleton

@Singleton
class NatsProductRepository(private val natsClient: NatsClient) : Repository<Product> {
    override fun create(entity: Product): UUID? {
        natsClient.sendProduct(entity)
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
