package com.camilo.main

import com.camilo.main.hooks.CustomFederationSchemaGeneratorHooks
import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
open class Application {

    @Bean
    open fun hooks(federatedTypeRegistry: FederatedTypeRegistry) =
        CustomFederationSchemaGeneratorHooks(federatedTypeRegistry)
}


@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
