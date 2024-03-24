package com.example.flux.section08.class03

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key1 = "id"

    Mono.deferContextual { Mono.just("ID: " + " " + it.get(key1)) }
        .publishOn(Schedulers.parallel())
        .contextWrite { it.put(key1, "itWorld") }
        .contextWrite { it.put(key1, "itVillage") }
        .subscribe { println(it) }

    Thread.sleep(100L)
}