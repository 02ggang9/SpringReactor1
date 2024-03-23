package com.example.flux.section07.class00

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main() {
    Flux.fromArray(arrayOf(1, 3, 5, 7, 9, 11, 13, 15))
        .parallel()
        .runOn(Schedulers.parallel())
        .subscribe { println("Thread Name -> [${Thread.currentThread().name}] On Next : $it") }

    Thread.sleep(100L)
}