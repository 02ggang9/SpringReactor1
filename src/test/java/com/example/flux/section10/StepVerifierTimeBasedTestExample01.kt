package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import reactor.test.scheduler.VirtualTimeScheduler
import java.time.Duration

class StepVerifierTimeBasedTestExample01 {

    // 특정 시간만큼 앞당긴다.
    @Test
    fun getCOVID19CountTest() {
        StepVerifier.withVirtualTime { TimeBasedExample.getCOVID19Count(
            Flux.interval(Duration.ofHours(12)).take(1)
        ) }
            .expectSubscription()
            .then { VirtualTimeScheduler.get().advanceTimeBy(Duration.ofHours(12)) }
            .expectNextCount(11)
            .expectComplete()
            .verify()
    }

}
