package com.example.flux.section08.class03

import reactor.core.publisher.Mono
import reactor.util.context.Context

const val HEADER_NAME_AUTH_TOKEN: String = "auth-token"

fun main() {
    postBook(Mono.just(Book("abcd-1111-3533-2809", "Reactor's", "ggang9")))
        .contextWrite { Context.of(HEADER_NAME_AUTH_TOKEN, "eyJhbGciOiJIUzUxMiJ9.eyJzdWI") }
        .subscribe { println(it) }
}

fun postBook(book: Mono<Book>): Mono<String> =
    Mono.zip(book, Mono.deferContextual { Mono.just(it.get<String>(HEADER_NAME_AUTH_TOKEN)) })
        .flatMap { Mono.just(it) }
        .flatMap { Mono.just("POST the book(" + it.t1.bookName + "," + it.t1.author + ") with token: " + it.t2) }

