package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class StepVerifierGeneralTestExample05 {

    // 한꺼번에 많은 숫자를 expectNext()
    @Test
    fun divideByTwoTest() {
        val source = Flux.just(2, 4, 6, 8, 10)
        StepVerifier.create(GeneralExample.divideByTwo(source))
            .expectNext(1,2,3,4,5)
            .expectComplete()
            .verify()
    }
}
