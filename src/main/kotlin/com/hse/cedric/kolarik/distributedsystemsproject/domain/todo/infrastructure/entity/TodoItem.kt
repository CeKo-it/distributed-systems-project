package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity

import com.hse.cedric.kolarik.distributedsystemsproject.configuration.annoations.NoArg
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("todoitem")
@NoArg
data class TodoItem(
    @Id
    val id: String? = null,
    var title: String,
    var text: String,
    val creationDate: LocalDateTime,
    var isDone: Boolean
)
