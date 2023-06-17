package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.AddTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.UpdateTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model.TodoResponse
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.incoming.TodoCrudService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo-api")
class TodoCommandController(val todoCrudService: TodoCrudService) {

    @PostMapping("todo")
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewTodo(@RequestBody addTodoCommand: AddTodoCommand): TodoResponse {
        return todoCrudService.handleAddNewTodo(addTodoCommand)
    }

    @GetMapping("todo/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    fun getTodoById(@PathVariable todoId: String): TodoResponse {
        return todoCrudService.handleGetTodo(todoId)
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    fun getAllTodos(): List<TodoResponse> {
        return todoCrudService.handleGetAllTodo()
    }

    @PutMapping("todo/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody updateTodoCommand: UpdateTodoCommand, @PathVariable id: String): TodoResponse {
        return todoCrudService.handleUpdateTodo(updateTodoCommand, id)
    }

    @DeleteMapping("todo/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTodo(@PathVariable todoId: String) {
        return todoCrudService.handleDeleteTodo(todoId)
    }
}
