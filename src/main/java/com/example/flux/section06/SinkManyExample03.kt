package com.example.flux.section06

import reactor.core.publisher.Sinks

fun main() {
    val replaySink = Sinks.many()
        .replay()
        .limit<Int>(2)

    val fluxView = replaySink.asFlux()

    replaySink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST)
    replaySink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST)
    replaySink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST)

    fluxView.subscribe { println("Subscribe1 $it") }
    fluxView.subscribe { println("Subscribe2 $it") }
}