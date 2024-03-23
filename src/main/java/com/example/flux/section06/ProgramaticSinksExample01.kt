package com.example.flux.section06

import reactor.core.publisher.Sinks
import java.util.stream.IntStream

fun main() {
    val tasks = 6

    val unicastSink = Sinks.many().unicast().onBackpressureBuffer<String>()
    val fluxView = unicastSink.asFlux()

    IntStream.range(1, tasks)
        .forEach { value ->
            try {
                Thread {
                    unicastSink.emitNext(doTask(value), Sinks.EmitFailureHandler.FAIL_FAST)
                    println("emitted $value")
                }.start()
                Thread.sleep(100L)
            } catch (e: Exception) { println("emission failed") }
        }

    fluxView.subscribe { println("on Next $it") }

    Thread.sleep(200L)
}