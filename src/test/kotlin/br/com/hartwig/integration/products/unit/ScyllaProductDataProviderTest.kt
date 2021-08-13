package br.com.hartwig.integration.products.unit

import br.com.hartwig.integration.products.core.domain.Product
import br.com.hartwig.integration.products.infrastructure.dataprovider.scylla.ScyllaProductDataProvider
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.clearAllMocks
import io.mockk.mockk
import java.math.BigDecimal
import java.util.UUID

class ScyllaProductDataProviderTest : StringSpec({
    clearAllMocks()

    val repository = ScyllaProductDataProvider(mockk(relaxed = true))
    val product = Product(UUID.randomUUID(), "111", "Carro", BigDecimal.valueOf(20000), null)

    "should create a product" {
        repository.create(product) shouldNotBe null
    }
})
