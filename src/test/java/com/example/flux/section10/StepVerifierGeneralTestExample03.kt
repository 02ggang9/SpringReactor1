package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

class StepVerifierGeneralTestExample03 {

    // verifyComplete()을 사용해서 검증하는 예제
    // as(description)을 사용해 실패한 expectXXXX()에게 description을 지정할 수 있음
    // 코틀린은 as가 예약어라 ₩를 사용해야 함
    @Test
    fun sayHelloReactorTest() {
        StepVerifier.create(GeneralExample.sayHelloReactor())
            .expectSubscription()
            .`as`("# expect subscription")
            .expectNext("Hi")
            .`as`("# expect Hi")
            .expectNext("Reactor")
            .`as`("# expect Reactor")
            .verifyComplete()
    }

}
