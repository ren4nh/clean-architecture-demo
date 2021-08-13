package br.com.hartwig.integration.products.infrastructure.dataprovider.api.repository

import io.micronaut.core.annotation.Introspected

@Introspected
data class ProductApiResponse(
    val id: String,
    val description: String,
    val price: Double,
    val sku: Long,
    val color: String,
    val brand: String
)
