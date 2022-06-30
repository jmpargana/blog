package com.jmpargana.blog

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.test.StepVerifier
import java.util.*

@ExtendWith(SpringExtension::class)
@DataR2dbcTest
internal class ArticleRepositoryTest {

    @Autowired
    lateinit var repository: ArticleRepository

    @Test
    fun `store article generates valid uuid`() {
        val article = Article(title = "title", content = "content")

        StepVerifier.create(repository.save(article))
            .expectNextMatches { it.id != null }
            .verifyComplete()
    }

    @Test
    fun `finds article from generated uuid`() {
        val article = Article(title = "findable", content = "content")

        val steps = repository.save(article).flatMap { repository.findById(it.id!!) }

        StepVerifier.create(steps)
            .expectNextMatches { it.title == article.title }
            .verifyComplete()
    }

    // This requires support from r2dbc (not yet available)
//    @Test
//    fun `match substring in content`() {
//        val article = Article(title = "matched", content = "content")
//        val steps = repository.save(article).flatMap { repository.matchNeedle("tent") }
//
//        StepVerifier.create(steps)
//            .expectNextMatches { it.title == article.title }
//            .verifyComplete()
//    }

}