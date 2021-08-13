package br.com.hartwig.integration.products.infrastructure.dataprovider.api.repository

import br.com.hartwig.commons.command.Repository
import br.com.hartwig.commons.log.AppLogger
import br.com.hartwig.integration.products.core.domain.Product
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ApiProductRepository(private val httpClient: HttpClient) : Repository<Product> {

    @Value("\${api.url}")
    private lateinit var url: String

    override fun create(entity: Product): UUID? {
        val req = HttpRequest.POST<Any>(url, entity)
        val responseCode = httpClient.toBlocking().exchange(req, String::class.java).code()
        if (responseCode != 201)
            throw Exception("Erro ao cadastrar produto")
        AppLogger.logger.info("Produto enviado para cadastro via api")
        return entity.id
    }

    override fun get(id: UUID): Product? {
        TODO("Not yet implemented")
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
