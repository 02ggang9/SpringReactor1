package com.example.flux.section09.class01

import reactor.core.publisher.Flux

fun main() {
    Flux.just(2, 4, 6, 8)
        .zipWith(Flux.just(1, 2, 3, 0)) { a, b -> a / b }
        .map { it + 2 }
        .checkpoint()
        .subscribe { println("onNext: $it") }
}
