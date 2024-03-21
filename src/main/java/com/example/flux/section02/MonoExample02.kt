package com.example.flux.section02

import reactor.core.publisher.Mono

fun main() {
    Mono.empty<Any>()
        .subscribe(
            { println(it) },
            { println("Error: $it") },
            { println("Done") }
        )
}