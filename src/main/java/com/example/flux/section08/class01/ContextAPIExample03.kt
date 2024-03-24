package com.example.flux.section08.class01

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context

fun main() {
    val key1 = "id"
    val key2 = "name"

    Mono.deferContextual {
        Mono.just(
            "ID: " + " " + it.get(key1) + ", "
                    + "Name: " + it.get(key2) + ", "
                    + "Job: " + it.getOrDefault("job", "Software Engineer")
        )
    }
    .publishOn(Schedulers.parallel())
    .contextWrite(Context.of(key1, "itVillage", key2, "ggang9"))
    .subscribe { println(it) }

    Thread.sleep(100L)
}