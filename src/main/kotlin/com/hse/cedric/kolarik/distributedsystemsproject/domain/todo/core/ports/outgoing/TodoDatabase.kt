package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.outgoing

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem
import java.util.Optional

interface TodoDatabase {
    fun createTodo(addTodo: TodoItem): TodoItem

    fun getTodo(todoId: String): Optional<TodoItem>

    fun updateTodo(updateTodo: TodoItem): TodoItem

    fun deleteTodo(todoId: String)
}
