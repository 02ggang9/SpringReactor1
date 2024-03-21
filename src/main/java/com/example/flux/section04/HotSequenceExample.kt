package com.example.flux.section04

import reactor.core.publisher.Flux
import reactor.core.publisher.Flux.fromStream
import java.time.Duration
import java.util.stream.Stream

fun main() {
    val concertFlux = fromStream(Stream.of("Singer A", "Singer B", "Singer C", "Singer D", "Singer E"))
        .delayElements(Duration.ofSeconds(1))
        .share()

    concertFlux.subscribe{ println("Subscriber 1: $it") }

    Thread.sleep(2500)

    concertFlux.subscribe{ println("Subscriber 2: $it") }

    Thread.sleep(3000)

}