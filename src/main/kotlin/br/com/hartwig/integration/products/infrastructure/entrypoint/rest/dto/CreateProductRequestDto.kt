package br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto

import br.com.hartwig.integration.products.core.interactor.create.CreateProductRequest
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Introspected
data class CreateProductRequestDto(
    @field:NotEmpty
    var sku: String?,
    @field:NotEmpty
    var name: String?,
    @field:NotNull
    @field:DecimalMin("0.01")
    var price: BigDecimal?,
    var color: String?
)

fun CreateProductRequestDto.toRequest() = CreateProductRequest(sku!!, name!!, price!!, color)
