package com.example.flux.section02

import reactor.core.publisher.Flux

fun main() {
    Flux.fromArray(arrayOf(3,6,7,9))
        .filter{ it > 6 }
        .map { it * 2 }
        .subscribe { println(it) }
}