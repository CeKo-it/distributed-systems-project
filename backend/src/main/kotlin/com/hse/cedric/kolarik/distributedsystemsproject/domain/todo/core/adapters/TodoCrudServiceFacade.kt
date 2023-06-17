package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.adapters

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.AddTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.application.model.UpdateTodoCommand
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.model.TodoResponse
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.incoming.TodoCrudService
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.core.ports.outgoing.TodoDatabase
import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoCrudServiceFacade(val todoDatabase: TodoDatabase) : TodoCrudService {

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

    override fun handleUpdateTodo(updateTodoCommand: UpdateTodoCommand, id: String): TodoResponse {
        var updateTodoItem = todoDatabase.getTodo(id).get()
        updateTodoItem.text = updateTodoCommand.text ?: updateTodoItem.text
        updateTodoItem.isDone = updateTodoCommand.isDone ?: updateTodoItem.isDone
        updateTodoItem.title = updateTodoCommand.title ?: updateTodoItem.title
        updateTodoItem = todoDatabase.updateTodo(updateTodoItem)

        return TodoResponse(updateTodoItem.id!!, updateTodoItem.title, updateTodoItem.text, updateTodoItem.creationDate, updateTodoItem.isDone)
    }

    override fun handleDeleteTodo(id: String) {
        todoDatabase.deleteTodo(id)
    }

    override fun handleGetTodo(id: String): TodoResponse {
        val todoItem = todoDatabase.getTodo(id).get()
        return TodoResponse(todoItem.id!!, todoItem.title, todoItem.text, todoItem.creationDate, todoItem.isDone)
    }

    override fun handleGetAllTodo(): List<TodoResponse> {
        val todoItems = todoDatabase.getAllTodos()
        return todoItems.stream().map { TodoResponse(it.id!!, it.title, it.text, it.creationDate, it.isDone) }.toList()
    }
}
