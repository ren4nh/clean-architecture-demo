package br.com.hartwig.integration.products.core.interactor.create

import br.com.hartwig.integration.products.core.dataprovider.ProductDataProvider
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CreateProductInteractorImpl(@Named("scylla") private val productDataProvider: ProductDataProvider) : CreateProductInteractor {

    override fun create(
        request: CreateProductRequest
    ): CreateProductResponse {
        val entity = request.toProduct()
        productDataProvider.create(entity)
        return CreateProductResponse(entity.id.toString(), entity.sku, entity.name, entity.price, entity.color)
    }
}
