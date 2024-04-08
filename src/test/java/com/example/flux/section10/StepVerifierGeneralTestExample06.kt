package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import reactor.test.StepVerifierOptions

class StepVerifierGeneralTestExample06 {

    // 검증에 실패할 경우에는 StepVerifierOptions에서 지정한 Scenario Name이 표시됨.

    @Test
    fun rangeNumberTest() {
        val source = Flux.range(0, 1000)
        StepVerifier.create(source.take(500),
            StepVerifierOptions.create().scenarioName("Verify from 0 to 499"))
            .expectSubscription()
            .expectNext(0)
            .expectNextCount(498)
            .expectNext(499)
            .expectComplete()
            .verify()
    }
}
