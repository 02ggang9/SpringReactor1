package com.example.flux.section05

import reactor.core.publisher.BufferOverflowStrategy
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

fun main() {
    Flux.interval(Duration.ofMillis(300L))
        .doOnNext { println("Emitted by original Flux: $it") }
        .onBackpressureBuffer(2,
            { println("Overflow & dropped: $it") },
            BufferOverflowStrategy.DROP_OLDEST
        )
        .doOnNext { println("Emitted by Buffer: $it") }
        .publishOn(Schedulers.parallel(), false, 1)
        .subscribe({
            Thread.sleep(1000L)
            println("Received by Subscriber: $it")
        },
            { println("Error: $it") }
        )

    Thread.sleep(3000L)
}