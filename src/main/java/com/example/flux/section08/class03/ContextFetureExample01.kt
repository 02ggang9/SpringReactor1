package com.example.flux.section08.class03

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context

fun main() {
    val key1 = "id"

    val mono = Mono.deferContextual {
        Mono.just("ID: " + it.get(key1))
    }
        .publishOn(Schedulers.parallel())

    mono.contextWrite { it.put(key1, "itVillage") }
        .subscribe { println("subscribe 1 : $it") }

    mono.contextWrite { it.put(key1, "itWorld!") }
        .subscribe { println("subscribe 2 : $it") }

    Thread.sleep(100L)
}