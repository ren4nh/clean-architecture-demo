package br.com.hartwig.integration.products.infrastructure.dataprovider.scylla.repository

import br.com.hartwig.commons.command.Repository
import br.com.hartwig.integration.products.core.domain.Product
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.BoundStatement
import com.datastax.oss.driver.api.core.cql.PreparedStatement
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ScyllaProductRepository(private val cqlSession: CqlSession) : Repository<Product> {

    override fun create(entity: Product): UUID? {
        val preparedInsert: PreparedStatement = cqlSession.prepare(
            "INSERT INTO products(id, name, sku, price, color) VALUES (?,?,?,?,?) IF NOT EXISTS"
        )

        val insert: BoundStatement = preparedInsert.bind(entity.id, entity.name, entity.sku, entity.price, entity.color)

        cqlSession.execute(insert)

        return entity.id
    }

    override fun get(id: UUID): Product? {
        val productResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM products WHERE id = $id allow filtering"
                )
        )

        return productResult
            .map { product ->
                Product(
                    product.getUuid("id")!!,
                    product.getString("sku")!!,
                    product.getString("name")!!,
                    product.getBigDecimal("price")!!,
                    product.getString("color")
                )
            }.firstOrNull()
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
