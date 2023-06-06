package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.adapters

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.AddTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model.TodoResponse
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.incoming.AddNewTodo
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.outgoing.TodoDatabase
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoFacade(val todoDatabase: TodoDatabase) : AddNewTodo {

    override fun handleAddNewTodo(addTodoCommand: AddTodoCommand): TodoResponse {
        var newTodo = TodoItem(
            null,
            addTodoCommand.title,
            addTodoCommand.text,
            LocalDateTime.now(),
            false
        )
        newTodo = todoDatabase.createTodo(newTodo)
        return TodoResponse(newTodo.id!!, newTodo.title, newTodo.text, newTodo.creationDate, newTodo.isDone)
    }
}
