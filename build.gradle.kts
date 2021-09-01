plugins {
    kotlin("jvm") version Dependencies.Versions.KOTLIN_VERSION
    kotlin("kapt") version Dependencies.Versions.KOTLIN_VERSION
    id("org.jetbrains.kotlin.plugin.allopen") version Dependencies.Versions.KOTLIN_VERSION
    id("com.github.johnrengelman.shadow") version Dependencies.Versions.JOHNRENGELMAN_SHADOW
    id("io.micronaut.application") version Dependencies.Versions.MICRONAUT_APPLICATION
    id("jacoco")
    id("org.jlleitschuh.gradle.ktlint") version Dependencies.Versions.KTLINT_VERSION
}

micronaut {
    version(Dependencies.Versions.MICRONAUT_VERSION)
    runtime("netty")
    testRuntime("kotest")
}

application {
    mainClass.set("br.com.hartwig.Application")
}

dependencies {
    implementation(platform(Dependencies.MicronautDependencies.MICRONAUT_BOM))
    implementation(Dependencies.MicronautDependencies.RUNTIME)
    implementation(Dependencies.MicronautDependencies.KOTLIN_RUNTIME)
    implementation(Dependencies.MicronautDependencies.INJECT_JAVA)
    implementation(Dependencies.MicronautDependencies.VALIDATION)
    implementation(Dependencies.MicronautDependencies.HTTP_SERVER_NETTY)
    implementation(Dependencies.MicronautDependencies.MANAGEMENT)
    implementation(Dependencies.MicronautDependencies.HTTP_CLIENT)
    implementation(Dependencies.KotlinDependencies.STDLIB_JDK8)
    implementation(Dependencies.KotlinDependencies.REFLECT)
    implementation(Dependencies.KotlinDependencies.JAVAX_ANNOT)
    implementation(Dependencies.MicronautDependencies.CASSANDRA)
    implementation(Dependencies.DataStaxDependencies.CORE)
    implementation(Dependencies.TestDependencies.JUNIT5)
    testImplementation(Dependencies.TestDependencies.CORE)
    testImplementation(Dependencies.TestDependencies.MOCKK)
    testImplementation(Dependencies.TestDependencies.TESTCONTAINER)
    implementation(Dependencies.TestDependencies.KOTEST)
    runtimeOnly(Dependencies.LogDependencies.LOGBACK)
    implementation(Dependencies.KotlinDependencies.JACKSON)
    implementation(Dependencies.MicronautDependencies.KAFKA)
    implementation(Dependencies.MicronautDependencies.SWAGGER)
}

kapt {
    arguments {
        arg("micronaut.processing.incremental", true)
        arg("micronaut.processing.annotations", "${Dependencies.App.GROUP}.*")
        arg("micronaut.processing.group", Dependencies.App.GROUP)
        arg("micronaut.processing.module", "complete")
        arg("micronaut.openapi.server.context.path", "/")
        arg(
            "micronaut.openapi.views.spec",
            "redoc.enabled=true,rapidoc.enabled=true,swagger-ui.enabled=true,swagger-ui.theme=flattop"
        )
    }
}

dependencies {
    kapt(platform(Dependencies.MicronautDependencies.MICRONAUT_BOM))
    kapt(Dependencies.MicronautDependencies.DATA_PROCESSOR)
    kapt(Dependencies.MicronautDependencies.INJECT_JAVA)
    kapt(Dependencies.MicronautDependencies.VALIDATION)
    kapt(Dependencies.MicronautDependencies.OPENAPI)

    kaptTest(platform(Dependencies.MicronautDependencies.MICRONAUT_BOM))
    kaptTest(Dependencies.MicronautDependencies.INJECT_JAVA)
}

tasks {
    jacocoTestReport {
        reports {
            csv.isEnabled = true
            csv.destination = file("$buildDir/jacocoCsv")
        }
    }
    test {
        finalizedBy("jacocoTestReport")
    }

    withType<Test> {
        useJUnitPlatform()
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + "-Xjsr305=strict"
            jvmTarget = Dependencies.Versions.JAVA_VERSION
        }
    }
}
