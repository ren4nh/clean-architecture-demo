package br.com.hartwig.integration.products.unit

import br.com.hartwig.integration.products.core.interactor.create.CreateProductInteractor
import br.com.hartwig.integration.products.core.interactor.create.CreateProductInteractorImpl
import br.com.hartwig.integration.products.core.interactor.create.CreateProductRequest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.clearAllMocks
import io.mockk.mockk
import java.math.BigDecimal

class CreateProductInteractorTest : StringSpec({
    clearAllMocks()

    val createProductInteractor: CreateProductInteractor = CreateProductInteractorImpl(mockk(relaxed = true))

    val request = CreateProductRequest("123", "Teste", BigDecimal.valueOf(1500.50), "azul")

    "should create a product" {
        createProductInteractor.create(request).id shouldNotBe null
    }
})
