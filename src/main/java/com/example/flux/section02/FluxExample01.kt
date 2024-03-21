package com.example.flux.section02

import lombok.extern.slf4j.Slf4j
import reactor.core.publisher.Flux
import java.util.logging.Logger

fun main() {
    Flux.just(6, 9, 13)
        .map { it % 2 }
        .subscribe{ println(it) }
}