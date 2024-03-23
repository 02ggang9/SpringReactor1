package com.example.flux.section06

import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.util.stream.IntStream

fun main() {
    val tasks = 6
    Flux.create {
        IntStream.range(1, tasks)
            .forEach { value -> it.next(doTask(value)) }
    }.subscribe { println(it) }

    Thread.sleep(500L)
}

fun doTask(value: Int) = "Task $value result"
