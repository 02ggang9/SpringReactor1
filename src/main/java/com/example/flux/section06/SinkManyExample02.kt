package com.example.flux.section06

import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.*
import reactor.core.publisher.Sinks.EmitFailureHandler.*

fun main() {
    val multicastSink = many()
        .multicast()
        .onBackpressureBuffer<Int>()

    val fluxView = multicastSink.asFlux()

    multicastSink.emitNext(1, FAIL_FAST)
    multicastSink.emitNext(2, FAIL_FAST)

    fluxView.subscribe { println("Subscriber1: $it") }
    fluxView.subscribe { println("Subscriber2: $it") }

    multicastSink.emitNext(3, FAIL_FAST)
}