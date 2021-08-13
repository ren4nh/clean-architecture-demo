package br.com.hartwig

import io.micronaut.runtime.Micronaut.build
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
    info = Info(
        title = "REST API - CA Demo",
        version = ("1.0"),
        description = "API Integration",
        license = License(name = "Apache 2.0", url = "https://foo.bar"),
    )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        build()
            .args(*args)
            .packages("br.com.hartwig")
            .start()
    }
}
