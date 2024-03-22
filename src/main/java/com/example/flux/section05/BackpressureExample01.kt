package com.example.flux.section05

import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux

fun main() {
    Flux.range(1, 5)
        .doOnNext { println("Do On Next: $it") }
        .doOnRequest { println("Do On Request: $it") }
        .subscribe(object : BaseSubscriber<Int>() {
            override fun hookOnSubscribe(subscription: Subscription) {
                request(1)
            }

            override fun hookOnNext(value: Int) {
                Thread.sleep(2000L)
                println("Subscriber received: $value")
                request(1)
            }
        })
}