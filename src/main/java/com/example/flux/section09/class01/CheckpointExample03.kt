package com.example.flux.section09.class01

import reactor.core.publisher.Flux

// 발생한 에러는 Operator 체인에 전파가 되기 때문에 각각의 checkpoint()에서 확인할 수 있다.

fun main() {
    Flux.just(2, 4, 6, 8)
        .zipWith(Flux.just(1, 2, 3, 0)) { a, b -> a / b }
        .checkpoint()
        .map { it + 2 }
        .checkpoint()
        .subscribe { println("onNext: $it")}
}
