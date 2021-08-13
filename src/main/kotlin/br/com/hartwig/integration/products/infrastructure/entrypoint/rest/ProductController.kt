package br.com.hartwig.integration.products.infrastructure.entrypoint.rest

import br.com.hartwig.integration.products.core.interactor.create.CreateProductInteractor
import br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto.CreateProductRequestDto
import br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto.CreateProductResponseDto
import br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto.toDto
import br.com.hartwig.integration.products.infrastructure.entrypoint.rest.dto.toRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import javax.validation.Valid

@Controller("/api/v1/products")
@Validated
@Tag(name = "Product")
class ProductController(private val createProductInteractor: CreateProductInteractor) {

    @Post
    @ApiResponses(
        ApiResponse(responseCode = "201", description = "Product created successfully!"),
        ApiResponse(responseCode = "400", description = "Error: Invalid fields.")
    )
    @Operation(summary = "Create product", description = "A new product will be created on this endpoint")
    @Status(HttpStatus.CREATED)
    fun create(@Body @Valid createProductDto: CreateProductRequestDto): HttpResponse<CreateProductResponseDto> {
        return try {
            val response = createProductInteractor.create(createProductDto.toRequest())
            HttpResponse.created(response.toDto())
        } catch (e: Exception) {
            e.printStackTrace()
            HttpResponse.badRequest()
        }
    }
}
