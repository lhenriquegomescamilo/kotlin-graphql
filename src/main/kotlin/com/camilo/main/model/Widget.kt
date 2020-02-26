package com.camilo.main.model

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import java.util.*

@KeyDirective(fields = FieldSet("id"))
@GraphQLDescription("A useful widget")
data class Widget(
    val id: Int,
    @GraphQLDescription("The widget's value that can be null")
    val value: Int? = null,
    val uuid: UUID = UUID.randomUUID()
) {
    @GraphQLDescription("return orignal value multiplied by target OR null if original value was null")
    fun multiplyValueBy(multiplier: Int) = value?.times(multiplier)

}
