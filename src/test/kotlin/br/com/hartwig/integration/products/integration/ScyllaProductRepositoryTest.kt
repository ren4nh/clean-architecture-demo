package br.com.hartwig.integration.products.integration

import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.scylla.repository.ScyllaProductRepository
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import org.testcontainers.containers.CassandraContainer
import org.testcontainers.utility.DockerImageName
import java.math.BigDecimal
import java.util.UUID
import javax.inject.Inject

@MicronautTest
class ScyllaProductRepositoryTest : StringSpec() {

    @Inject
    lateinit var repository: ScyllaProductRepository

    private val scyllaContainer = CassandraContainer<Nothing>(DockerImageName.parse("scylladb/scylla:4.3.0").asCompatibleSubstituteFor("cassandra"))

    init {
        val product = Product(UUID.randomUUID(), "111", "teste", BigDecimal.valueOf(100), null)

        "should save a product" {
            repository.create(product)
            val productSaved = repository.get(product.id)
            productSaved shouldBe product
        }
    }

    override fun beforeSpec(spec: Spec) {
        scyllaContainer.withExposedPorts(9042)
        scyllaContainer.withInitScript("create-keyspace.cql")
        scyllaContainer.withCommand("--smp 1 --memory 750M --overprovisioned 1")
        scyllaContainer.start()
        System.getProperties()["cassandra.default.basic.contact-points"] = listOf("localhost:" + scyllaContainer.getMappedPort(9042))
        super.beforeSpec(spec)
    }

    override fun afterSpec(spec: Spec) {
        scyllaContainer.stop()
        super.afterSpec(spec)
    }
}
