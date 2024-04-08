package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration

class StepVerifierTimeBasedTestExample02 {

    @Test
    fun getCOVID19CountTest() {
        StepVerifier.withVirtualTime {
            TimeBasedExample.getCOVID19Count(
                Flux.interval(Duration.ofHours(12)).take(1)
            )
        }
            .expectSubscription()
            .thenAwait(Duration.ofHours(12))
            .expectNextCount(11)
            .expectComplete()
            .verify()
    }

}
