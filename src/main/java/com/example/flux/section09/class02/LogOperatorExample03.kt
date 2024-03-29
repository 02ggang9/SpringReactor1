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
        .log("Fruit.Source")
        .map { it.lowercase() }
        .log("Fruit.Lower")
        .map { it.substring(0, it.length-1) }
        .log("Fruit.Substring")
        .map { fruits[it] }
        .log("Fruit.Name")
        .subscribe { println("onNext: $it") }
}
