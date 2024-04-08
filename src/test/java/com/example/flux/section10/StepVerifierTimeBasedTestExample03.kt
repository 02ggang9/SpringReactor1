package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration

class StepVerifierTimeBasedTestExample03 {

    // verify(Duration.ofSeconds(3))을 통해 설정한 시간내에 검증이 끝나는지를 확인할 수 있음.
    @Test
    fun getCOVID19CountTest() {
        StepVerifier.create(
            TimeBasedExample.getCOVID19Count(
                Flux.interval(Duration.ofMinutes(1)).take(1)
            )
        )
            .expectSubscription()
            .expectNextCount(11)
            .expectComplete()
            .verify(Duration.ofSeconds(3))
    }
}
