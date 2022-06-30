package com.jmpargana.blog

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}


@Configuration
class BlogAppRouter {

	@Bean
	fun route(handler: BlogHandler) = router {
		(accept(MediaType.APPLICATION_JSON) and "/blogs").nest {
			GET("/{id}", handler::getById)
		}
	}
}