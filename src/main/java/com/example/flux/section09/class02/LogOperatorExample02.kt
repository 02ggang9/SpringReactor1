package com.example.flux.section09.class02

import reactor.core.publisher.Flux

fun main() {
    val fruits = mapOf(
        "banana" to "바나나",
        "apple" to "사과",
        "pear" to "배",
        "grape" to "포도"
    )

    Flux.fromArray(arrayOf("BANANAS", "APPLES", "PEARS", "MELONS"))
        .log()
        .map { it.lowercase() }
        .log()
        .map { it.substring(0, it.length-1) }
        .log()
        .map { fruits[it] }
        .log()
        .subscribe { println("onNext: $it") }
}
