package com.example.flux.section07.class01

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main() {
    Flux.fromArray(arrayOf(1, 3, 5, 7))
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next from array : $it") }
        .publishOn(Schedulers.parallel())
        .filter{ it > 3 }
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next filter : $it") }
        .subscribeOn(Schedulers.boundedElastic())
        .map { it * 10 }
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next map : $it") }
        .subscribe { println("Thread Name -> [${Thread.currentThread().name}] On Next : $it") }

    Thread.sleep(500L)
}