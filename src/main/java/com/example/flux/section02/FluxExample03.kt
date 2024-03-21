package com.example.flux.section02

import reactor.core.publisher.Mono

fun main() {
    Mono.justOrEmpty<Any>(null)
        .concatWith(Mono.justOrEmpty("World"))
        .subscribe{ println(it) }
}