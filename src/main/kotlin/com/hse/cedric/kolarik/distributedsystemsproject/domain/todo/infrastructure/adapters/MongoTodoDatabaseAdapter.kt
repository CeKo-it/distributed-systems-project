package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.adapters

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.outgoing.TodoDatabase
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.TodoRepository
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem
import org.springframework.stereotype.Service

@Service
class MongoTodoDatabaseAdapter(val todoRepository: TodoRepository) : TodoDatabase {

    override fun createTodo(todoItem: TodoItem): TodoItem {
        return todoRepository.save(todoItem)
    }
}
