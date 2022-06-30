package com.jmpargana.blog

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.*

@Repository
interface ArticleRepository : ReactiveCrudRepository<Article, UUID> {

    @Query("")
    fun matchNeedle(needle: String) : Flux<Article>

}