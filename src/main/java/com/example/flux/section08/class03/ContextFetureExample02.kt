package com.example.flux.section08.class03

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key1 = "id"
    val key2 = "name"

    Mono.deferContextual { Mono.just<String>(it.get(key1)) }
        .publishOn(Schedulers.parallel())
        .contextWrite { it.put(key2, "Kevin") }
        .transformDeferredContextual { mono, ctx ->
            mono.map { it + ", " + ctx.getOrDefault(key2, "Tom") }
        }
        .contextWrite { it.put(key1, "itVillage") }
        .subscribe { println(it) }

    Thread.sleep(100L)
}