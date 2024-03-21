package com.example.flux.section03

import reactor.core.publisher.Flux

fun main() {
    Flux.just(6, 9, 13)
        .map { it % 2 }
        .subscribe{ println(it) }
}