package br.com.hartwig.integration.products.core.interactor.create

interface CreateProductInteractor {
    fun create(request: CreateProductRequest): CreateProductResponse
}
