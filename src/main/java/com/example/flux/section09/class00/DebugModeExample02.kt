package com.example.flux.section09.class00

import reactor.core.publisher.Flux
import reactor.core.publisher.Hooks

fun main() {
    Hooks.onOperatorDebug()

    Flux.just(2,4,6,8)
        .zipWith(Flux.just(1,2,3,0)) { a, b -> a / b }
        .subscribe { println("onNext: $it") }
}
