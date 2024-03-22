package com.example.flux.section05

import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux

fun main() {
    var count = 0
    Flux.range(1, 5)
        .doOnNext { println("Do On Next: $it") }
        .doOnRequest { println("Do On Request: $it") }
        .subscribe(object: BaseSubscriber<Int>() {
            override fun hookOnSubscribe(subscription: Subscription) {
                request(1)
            }

            override fun hookOnNext(value: Int) {
                count++
                println("HookOnNext: $value")
                if (count == 2) {
                    Thread.sleep(2000L)
                    request(2)
                    count = 0
                }
            }
        })
}