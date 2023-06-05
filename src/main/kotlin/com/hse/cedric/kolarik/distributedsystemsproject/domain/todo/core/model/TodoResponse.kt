package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model

import java.time.LocalDateTime

data class TodoResponse(
    val id: String,
    val title: String,
    val text: String,
    val creationDate: LocalDateTime,
    val isDone: Boolean
)
