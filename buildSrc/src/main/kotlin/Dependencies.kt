class Dependencies {

    object App {
        const val GROUP = "br.com.hartwig"
        const val VERSION = "1.0-SNAPSHOT"
    }

    object Versions {
        const val JAVA_VERSION = "11"
        const val KOTLIN_VERSION = "1.4.32"
        const val MICRONAUT_VERSION = "2.3.3"
        const val JOHNRENGELMAN_SHADOW = "6.1.0"
        const val MICRONAUT_APPLICATION = "1.4.2"
        const val CASSANDRA_VERSION = "4.0.0"
        const val DATASTAX_VERSION = "4.12.0"
        const val KOTEST_VERSION = "4.4.2"
        const val KOTEST_MICRONAUT_VERSION = "2.3.3"
        const val MOCKK_VERSION = "1.10.6"
        const val JACKSON_VERSION = "2.8.+"
        const val KTLINT_VERSION = "10.1.0"
        const val TESTCONTAINER_VERSION = "1.15.3"
        const val OPENAPI_VERSION = "2.6.0"
    }

    object KotlinDependencies {
        const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN_VERSION}"
        val REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN_VERSION}"
        const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.JACKSON_VERSION}"
        const val JAVAX_ANNOT = "javax.annotation:javax.annotation-api"
    }

    object MicronautDependencies {
        const val MICRONAUT_BOM = "io.micronaut:micronaut-bom:${Versions.MICRONAUT_VERSION}"
        const val RUNTIME = "io.micronaut:micronaut-runtime"
        const val KOTLIN_RUNTIME = "io.micronaut.kotlin:micronaut-kotlin-runtime"
        const val INJECT_JAVA = "io.micronaut:micronaut-inject-java"
        const val VALIDATION = "io.micronaut:micronaut-validation"
        const val DATA_PROCESSOR = "io.micronaut.data:micronaut-data-processor"
        const val HTTP_CLIENT = "io.micronaut:micronaut-http-client"
        const val HTTP_SERVER_NETTY = "io.micronaut:micronaut-http-server-netty"
        const val MANAGEMENT = "io.micronaut:micronaut-management"
        const val CASSANDRA = "io.micronaut.cassandra:micronaut-cassandra:${Versions.CASSANDRA_VERSION}"
        const val KAFKA = "io.micronaut.kafka:micronaut-kafka"
        const val OPENAPI = "io.micronaut.openapi:micronaut-openapi:${Versions.OPENAPI_VERSION}"
        const val SWAGGER = "io.swagger.core.v3:swagger-annotations"
    }

    object LogDependencies {
        const val LOGBACK = "ch.qos.logback:logback-classic"
    }

    object DataStaxDependencies {
        const val CORE = "com.datastax.oss:java-driver-core:${Versions.DATASTAX_VERSION}"
    }

    object TestDependencies {
        const val JUNIT5 = "io.kotest:kotest-runner-junit5-jvm:${Versions.KOTEST_VERSION}"
        const val KOTEST = "io.micronaut.test:micronaut-test-kotest:${Versions.KOTEST_MICRONAUT_VERSION}"
        const val CORE = "io.kotest:kotest-assertions-core-jvm:${Versions.KOTEST_VERSION}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK_VERSION}"
        const val TESTCONTAINER = "org.testcontainers:cassandra:${Versions.TESTCONTAINER_VERSION}"
    }

}
