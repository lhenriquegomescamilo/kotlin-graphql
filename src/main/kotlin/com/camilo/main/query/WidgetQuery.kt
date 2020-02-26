package com.camilo.main.query

import com.camilo.main.model.Widget
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component


@Component
class WidgetQuery : Query {

    @GraphQLDescription("creates new widget for given ID")
    fun widgetById(@GraphQLDescription("The special integratient") id: Int): Widget? = Widget(id)
}
