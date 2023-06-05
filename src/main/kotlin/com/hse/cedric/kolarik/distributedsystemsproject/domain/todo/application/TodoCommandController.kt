package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.AddTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model.TodoResponse
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.incoming.AddNewTodo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo-api")
class TodoCommandController(val addNewTodo: AddNewTodo) {

    @PostMapping("")
    fun addNewTodo(@RequestBody addTodoCommand: AddTodoCommand): TodoResponse {
        return addNewTodo.handleAddNewTodo(addTodoCommand)
    }
}
