Projeto criado para estudos da clean architecture

## Frameworks utilizados

- Micronaut
- Kotest
- Testcontainers
- ScyllaDB
- Apache Kafka
- Jacoco

## Como rodar

```
docker-compose up -d --build
```

Este exemplo possui 3 implementações de data provider, para realizar a troca, deve ser editado o arquivo CreateProductInteractorImpl na anotação @Named. Ela pode receber 3 tipos que são: api, nats, scylla
No caso de nenhuma ser escolhida ele utilizará a implementação que contiver a anotação @Primary 

Ex:

```
package br.com.hartwig.integration.products.core.interactor.create

import br.com.hartwig.integration.products.core.dataprovider.ProductDataProvider
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class CreateProductInteractorImpl(@Named("api") private val productDataProvider: ProductDataProvider) : CreateProductInteractor {

    override fun create(
        request: CreateProductRequest
    ): CreateProductResponse {
        val entity = request.toProduct()
        productDataProvider.create(entity)
        return CreateProductResponse(entity.id.toString(), entity.sku, entity.name, entity.price, entity.color)
    }
}

```


O exemplo tambem possui 2 entrypoints que são via rest e mensageria atraves do kafka

## Documentação da api

Está habilitado 3 implementações de ui para o open api, acessíveis através do links

```
   http://localhost:8081/swagger-ui
   http://localhost:8081/swagger/views/redoc
   http://localhost:8081/swagger/views/rapidoc
```

## Como rodar os testes

Existem 2 tipos de testes na aplicação, os unitários e integração. Para rodar os testes de integração é necessário possui Docker instalado na máquina.

### Rodar todos os testes

```
gradlew clean test --info
```

### Rodar testes unitários

```
gradlew clean test --info --tests="br.com.hartwig.integration.products.unit.*"
```

### Rodar testes de integração

```
gradlew clean test --info --tests="br.com.hartwig.integration.products.integration.*"
```
