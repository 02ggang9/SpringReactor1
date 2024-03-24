package com.example.flux.section07.class02

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val flux = Mono.just(1)
        .publishOn(Schedulers.newParallel("Parallel Thread", 4, true))

    flux.subscribe {
        Thread.sleep(5000L)
        println("Thread Name -> [${Thread.currentThread().name}] Subscribe 1 : $it")
    }

    flux.subscribe {
        Thread.sleep(4000L)
        println("Thread Name -> [${Thread.currentThread().name}] Subscribe 2 : $it")
    }

    flux.subscribe {
        Thread.sleep(3000L)
        println("Thread Name -> [${Thread.currentThread().name}] Subscribe 3 : $it")
    }

    flux.subscribe {
        Thread.sleep(2000L)
        println("Thread Name -> [${Thread.currentThread().name}] Subscribe 4 : $it")
    }

    Thread.sleep(6000L)
}