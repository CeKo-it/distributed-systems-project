package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.outgoing

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem

interface TodoDatabase {
    fun createTodo(add: TodoItem): TodoItem
}
