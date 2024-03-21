package com.example.flux

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main() {
    Flux.just("Hello", "Reactor")
        .map { it.lowercase() }
        .subscribe{ println(it) }

}