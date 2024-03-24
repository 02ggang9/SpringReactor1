package com.example.flux.section07.class01

import reactor.core.publisher.Flux

fun main() {
    Flux.fromArray(arrayOf(1, 3, 5, 7, 9))
        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] On Next : $it") }
        .filter{ it > 3 }
        .map { it * 10 }
        .subscribe { println("Thread Name -> [${Thread.currentThread().name}] On Next : $it") }
}