package com.camilo.main.query

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class SimpleQuery : Query {
    fun dataFromBaseApp() = "Hello from base app"

    @Deprecated(message = "Old deprecated query", replaceWith = ReplaceWith("DatafromBaseApp"))
    fun deprecatedBaseAppQuery() = "This is deprecated"
}
