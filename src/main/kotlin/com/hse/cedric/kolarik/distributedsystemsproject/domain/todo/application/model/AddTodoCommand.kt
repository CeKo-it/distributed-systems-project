package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model

data class AddTodoCommand(
    val title: String,
    val text: String
)
