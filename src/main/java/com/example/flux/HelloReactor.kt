package com.example.flux

import reactor.core.publisher.Mono

fun main() {
    Mono.just("Hello, Reactor!")
        .subscribe { println(it) }
}