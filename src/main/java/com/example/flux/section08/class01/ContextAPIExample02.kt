package com.example.flux.section08.class01

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context

fun main() {
    val key1 = "id"
    val key2 = "name"
    val key3 = "country"

    Mono.deferContextual { Mono.just("ID: " + " " + it.get(key1) + ", " + "Name: " + it.get(key2) + ", " + "Country: " + it.get(key3)) }
        .publishOn(Schedulers.parallel())
        .contextWrite { it.putAll(Context.of(key2, "ggang9", key3, "Korea").readOnly()) }
        .contextWrite { it.put(key1, "itVillage") }
        .subscribe { println(it) }

    Thread.sleep(100L)
}