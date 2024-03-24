package com.example.flux.section07.class02

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main() {
    Flux.fromArray(arrayOf(1, 3, 5, 7))
        .publishOn(Schedulers.parallel())
        .filter{ it > 3 }
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next filter : $it") }
        .publishOn(Schedulers.immediate())
        .map { it * 10 }
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next map : $it") }
        .subscribe { println(it) }

    Thread.sleep(200L)
}