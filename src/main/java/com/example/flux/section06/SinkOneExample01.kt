package com.example.flux.section06

import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST

fun main() {
    val sinkOne = Sinks.one<String>()
    val mono = sinkOne.asMono()

    sinkOne.emitValue("Hello Reactor!", FAIL_FAST)

    mono.subscribe { println("Subscriber1 $it") }
    mono.subscribe { println("Subscriber2 $it") }
}