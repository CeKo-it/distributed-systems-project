package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.incoming

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.AddTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.UpdateTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model.TodoResponse

interface TodoCrudService {
    fun handleAddNewTodo(addTodoCommand: AddTodoCommand): TodoResponse
    fun handleUpdateTodo(updateTodoCommand: UpdateTodoCommand, id: String): TodoResponse
    fun handleDeleteTodo(id: String)
    fun handleGetTodo(id: String): TodoResponse
    fun handleGetAllTodo(): List<TodoResponse>
}
