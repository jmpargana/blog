package com.jmpargana.blog

import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

class BlogHandler {

    fun getById(req: ServerRequest) : Mono<ServerResponse> {
        return ok().bodyValue("")
    }

}
