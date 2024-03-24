package com.example.flux.section07.class01

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main() {
    Flux.fromArray(arrayOf(1, 3, 5, 7))
        .subscribeOn(Schedulers.boundedElastic())
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next from Array : $it") }
        .filter{ it > 3 }
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next filter : $it") }
        .map { it * 10 }
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next map : $it") }
        .subscribe { println("Thread Name -> [${Thread.currentThread().name}] On Next : $it") }

    Thread.sleep(500L)
}