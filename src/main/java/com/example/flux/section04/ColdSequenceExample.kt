package com.example.flux.section04

import reactor.core.publisher.Flux

fun main() {
    val coldFlux = Flux.fromIterable(listOf("RED", "YELLOW", "PINK"))
                .map { it.lowercase() }

    coldFlux.subscribe{ println("Subscriber 1: $it") }
    println("-------------------")
    coldFlux.subscribe{ println("Subscriber 2: $it") }
}