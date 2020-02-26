package com.camilo.main.query

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class NestedQuery: Query {
    fun getSimpleNestedObject() = listOf(SelfReferenceObject())
}

data class SelfReferenceObject(
    val descrption: String = "SelfReferenceObject",
    val id: Int = Random.nextInt()
) {

    fun nextObject() = listOf(SelfReferenceObject())

}
