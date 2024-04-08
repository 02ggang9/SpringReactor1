package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

class StepVerifierGeneralTestExample01 {

    @Test
    fun sayHelloReactorTest() {
        StepVerifier.create(Mono.just("Hello Reactor"))
            .expectNext("Hello Reactor")
            .expectComplete()
            .verify()
    }

}
