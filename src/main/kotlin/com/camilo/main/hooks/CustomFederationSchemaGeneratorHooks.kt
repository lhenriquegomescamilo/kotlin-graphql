package com.camilo.main.hooks

import com.expediagroup.graphql.federation.FederatedSchemaGeneratorHooks
import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import graphql.schema.GraphQLType
import java.util.*
import kotlin.reflect.KType
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue

class CustomFederationSchemaGeneratorHooks(federatedTypeRegistry: FederatedTypeRegistry) :
    FederatedSchemaGeneratorHooks(federatedTypeRegistry) {
    override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier) {
        UUID::class -> graphQLUUIDtype
        else -> super.willGenerateGraphQLType(type)
    }
}

internal val graphQLUUIDtype = GraphQLScalarType.newScalar().name("UUID")
    .name("UUID")
    .description("A type representing a formatted java.util.UUID")
    .coercing(UUIDCoercing)
    .build()

private object UUIDCoercing : Coercing<UUID, String> {
    override fun parseValue(input: Any?): UUID {
        return UUID.fromString(serialize(input))
    }

    override fun parseLiteral(input: Any?): UUID {
        val uuidString = (input as? StringValue)?.value
        return UUID.fromString(uuidString)
    }

    override fun serialize(dataFetcherResult: Any?): String {
        return dataFetcherResult.toString()
    }
}
