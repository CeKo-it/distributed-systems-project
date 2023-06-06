package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model

import com.hse.cedric.kolarik.distributedsystemsproject.configuration.annoations.NoArg

@NoArg
data class AddTodoCommand(
    val title: String,
    val text: String
)
