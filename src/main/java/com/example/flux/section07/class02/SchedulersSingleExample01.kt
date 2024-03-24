package com.example.flux.section07.class02

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main() {
    doTask("task1").subscribe { println("task1 -> $it") }
    doTask("task2").subscribe { println("task2 -> $it") }

    Thread.sleep(200L)
}

//fun doTask(taskName: String) =
//    Flux.fromArray(arrayOf(1, 3, 5, 7))
//        .publishOn(Schedulers.single())
//        .filter { it > 3 }
//        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] $taskName On Next filter : $it") }
//        .map { it * 10 }
//        .doOnNext { println("Thread Name -> [${Thread.currentThread().name}] $taskName On Next map : $it") }

