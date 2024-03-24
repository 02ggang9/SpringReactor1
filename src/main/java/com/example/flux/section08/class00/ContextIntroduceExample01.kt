package com.example.flux.section08.class00

import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

// contextWrite() 로 Context에 값을 쓸 수 있고, ContextView.get() 을 통해서 Context에 저장된 값을 read 할 수 있다.
// ContextView는 deferContextual() 또는 transformDefferedContextual() 을 통해 제공된다.



fun main() {
    val key = "message"
    val mono =
        Mono.deferContextual { Mono.just("Hello" + " " + it.get(key)).doOnNext { println("Do on Next $it") } }
            .subscribeOn(Schedulers.boundedElastic())
            .publishOn(Schedulers.parallel())
            .transformDeferredContextual { mono, ctx -> mono.map { it + " " + ctx.get(key) } }
            .contextWrite { it.put(key, "Reactor") }

    mono.subscribe { println(it) }

    Thread.sleep(100L)
}