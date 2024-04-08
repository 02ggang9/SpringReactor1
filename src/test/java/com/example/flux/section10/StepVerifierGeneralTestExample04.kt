package com.example.flux.section10

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class StepVerifierGeneralTestExample04 {

    // onError signal 발생 여부를 검증
    // 그냥 expectError()를 사용해도 되지만, 예측한 에러의 타입을 지정할 수 있음.
    @Test
    fun occurErrorTest() {
        val source = Flux.just(2, 4, 6, 8, 10)
        StepVerifier.create(GeneralExample.occurError(source))
            .expectNext(1)
            .expectNext(2)
            .expectNext(3)
            .expectNext(4)
            .expectError(ArithmeticException::class.java)
            .verify()

    }

}
