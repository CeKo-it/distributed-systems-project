package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.incoming

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.AddTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model.TodoResponse

interface AddNewTodo {
    fun handleAddNewTodo(addTodoCommand: AddTodoCommand): TodoResponse
}
