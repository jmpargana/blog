package com.jmpargana.blog

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [BlogAppRouter::class, BlogHandler::class])
@WebFluxTest
class BlogApplicationKtTest {

    @Autowired
    lateinit var client: WebTestClient

    @MockBean
    lateinit var articleRepository: ArticleRepository


    @Test
    fun `test client is initialized`() {
        Assertions.assertThat(client).isNotNull
    }

    @Test
    fun `get by id works`() {
        client.get().uri("/blogs/1").exchange().expectStatus().isOk
    }

}