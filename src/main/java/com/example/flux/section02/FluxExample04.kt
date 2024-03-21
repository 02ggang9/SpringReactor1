package com.example.flux.section02

import reactor.core.publisher.Flux

fun main() {
    Flux.concat(
        Flux.just("Venus"),
        Flux.just("Earth"),
        Flux.just("Mars"),
    )
        .collectList()
        .subscribe{ println(it) }
}