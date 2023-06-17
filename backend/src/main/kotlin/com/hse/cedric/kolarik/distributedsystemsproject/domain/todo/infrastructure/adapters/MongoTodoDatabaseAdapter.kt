package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.adapters

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.outgoing.TodoDatabase
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.TodoRepository
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem
import org.springframework.stereotype.Service
import java.util.NoSuchElementException
import java.util.Optional

@Service
class MongoTodoDatabaseAdapter(val todoRepository: TodoRepository) : TodoDatabase {

    override fun createTodo(addTodo: TodoItem): TodoItem {
        return todoRepository.save(addTodo)
    }

    override fun getTodo(todoId: String): Optional<TodoItem> {
        return todoRepository.findById(todoId)
    }

    override fun updateTodo(updateTodo: TodoItem): TodoItem {
        return todoRepository.save(updateTodo)
    }

    override fun deleteTodo(todoId: String) {
        if (!todoRepository.findById(todoId).isEmpty) {
            todoRepository.deleteById(todoId)
        } else {
            throw NoSuchElementException()
        }
    }

    override fun getAllTodos(): List<TodoItem> {
        return todoRepository.findAll()
    }
}
