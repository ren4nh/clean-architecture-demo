package br.com.hartwig.integration.products.unit

import br.com.hartwig.integration.products.core.interactor.create.CreateProductInteractor
import br.com.hartwig.integration.products.core.interactor.create.CreateProductInteractorImpl
import br.com.hartwig.integration.products.infrastructure.entrypoint.rest.ProductController
import br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto.CreateProductRequestDto
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.mockk
import java.math.BigDecimal

class ProductControllerTest : StringSpec({

    clearAllMocks()

    val createProductInteractor: CreateProductInteractor = CreateProductInteractorImpl(mockk(relaxed = true))
    val productController = ProductController(createProductInteractor)

    val request = CreateProductRequestDto("124", "Mascara", BigDecimal.valueOf(12.50), "Verde")

    "should create a product" {
        productController.create(request).code() shouldBe 201
    }
})
