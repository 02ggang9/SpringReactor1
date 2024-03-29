package com.example.flux.section09.class00

import reactor.core.publisher.Flux
import reactor.core.publisher.Hooks

fun main() {
    Hooks.onOperatorDebug()
    val fruits = mapOf(
        "banana" to "바나나",
        "apple" to "사과",
        "pear" to "배",
        "grape" to "포도"
    )

    Flux.fromArray(arrayOf("BANANAS", "APPLES", "PEARS", "MELONS"))
        .map { it.lowercase() }
        .map { it.substring(0, it.length-1) }
        .map { fruits[it] }
        .map { "맛있는 $it" }
        .subscribe { println("onNext: $it") }


}
