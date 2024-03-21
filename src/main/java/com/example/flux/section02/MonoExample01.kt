package com.example.flux.section02

import reactor.core.publisher.Mono

fun main() {
    Mono.just("Hello Reactor!")
        .subscribe{ println(it) }
}