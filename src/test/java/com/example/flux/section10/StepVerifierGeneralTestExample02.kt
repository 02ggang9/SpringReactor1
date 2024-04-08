package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

class StepVerifierGeneralTestExample02 {

    // expectNext()를 사용해서 emit된 n개의 데이터를 검증하는 예제
    @Test
    fun sayHelloReactorTest() {
        StepVerifier.create(GeneralExample.sayHelloReactor())
            .expectSubscription()
            .expectNext("Hello")
            .expectNext("Reactor")
            .expectComplete()
            .verify()
    }

}
