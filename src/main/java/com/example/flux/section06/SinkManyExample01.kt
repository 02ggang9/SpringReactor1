package com.example.flux.section06

import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.*

fun main() {
    val unicastSink = Sinks.many()
        .unicast()
        .onBackpressureBuffer<Int>()

    val fluxView = unicastSink.asFlux()

    unicastSink.emitNext(1, FAIL_FAST)
    unicastSink.emitNext(2, FAIL_FAST)

    fluxView.subscribe { println("Subscriber1: $it") }

    unicastSink.emitNext(3, FAIL_FAST)

    fluxView.subscribe { println("Subscriber2: $it")}
}