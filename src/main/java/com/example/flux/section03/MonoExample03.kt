package com.example.flux.section03

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import reactor.core.publisher.Mono
import java.util.Collections.singletonList

fun main() {
    val worldTimeUri = UriComponentsBuilder.newInstance().scheme("http")
        .host("worldtimeapi.org")
        .port(80)
        .path("/api/timezone/Asia/Seoul")
        .build()
        .encode()
        .toUri()

    val restTemplate = RestTemplate()
    val headers = HttpHeaders()
    headers.accept = singletonList(MediaType.APPLICATION_JSON)

    Mono.just(restTemplate.exchange(worldTimeUri, HttpMethod.GET, HttpEntity<String>(headers), String::class.java))
        .map {
            ObjectMapper().readTree(it.body)
                .at("/datetime")
                .asText()
        }
        .subscribe(
            { println(it) },
            { println("Error: $it") },
            { println("Done") }
        )

}