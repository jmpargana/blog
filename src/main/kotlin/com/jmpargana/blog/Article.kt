package com.jmpargana.blog

import org.springframework.data.annotation.Id
import java.util.*

data class Article(
    @Id val id: UUID? = null,
    val title: String,
    val content: String,
)