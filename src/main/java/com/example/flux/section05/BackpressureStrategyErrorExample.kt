package com.example.flux.section05

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

// DownStream 으로 전달 할 데이터가 버퍼에 가득 찰 경우, Exception 을 발생 시키는 전략

fun main() {
    Flux.interval(Duration.ofMillis(1L))
        .onBackpressureError()
        .doOnNext { println("Emitted by original Flux: $it") }
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