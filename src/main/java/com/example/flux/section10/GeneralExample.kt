package com.example.flux.section10

import reactor.core.publisher.Flux

class GeneralExample {

    companion object {
        fun sayHelloReactor(): Flux<String> {
            return Flux.just("Hello", "Reactor")
        }

        fun occurError(source: Flux<Int>): Flux<Int> {
            return source.zipWith(Flux.just(2,2,2,2,0)) { a, b -> a / b }
        }

        fun divideByTwo(source: Flux<Int>): Flux<Int> {
            return source.zipWith(Flux.just(2,2,2,2,2)) { a, b -> a / b }
        }
    }

}
