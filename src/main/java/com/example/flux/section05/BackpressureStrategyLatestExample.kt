package com.example.flux.section05

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

fun main() {
    Flux.interval(Duration.ofMillis(1L))
        .onBackpressureLatest()
        .publishOn(Schedulers.parallel())
        .subscribe(
            {
                Thread.sleep(5L)
                println("Received by Subscriber: $it")
            },
            { println("Error: $it") }
        )

    Thread.sleep(2000L)
}