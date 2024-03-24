package com.example.flux.section08.class03

import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context
import reactor.util.context.ContextView


fun main() {
    val key1 = "id"

    Mono.just("Kevin")
        .transformDeferredContextual { _, ctx: ContextView -> ctx.get<Publisher<String>>("job") }
        .flatMap { name -> Mono.deferContextual { ctx ->
            Mono.just(ctx.get<String>(key1) + ", " + name)
                .transformDeferredContextual { mono, innerCtx -> mono.map { it + ", " + innerCtx.get("job") } }
                .contextWrite { it.put("job", "Software Engineer") }
        } }
        .publishOn(Schedulers.parallel())
        .contextWrite { it.put(key1, "itVillage") }
        .subscribe { println(it) }

    Thread.sleep(100L)
}