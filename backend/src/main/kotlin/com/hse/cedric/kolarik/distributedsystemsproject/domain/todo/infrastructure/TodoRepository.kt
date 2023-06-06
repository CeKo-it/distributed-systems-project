package com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure

import com.hse.cedric.kolarik.distributedsystemsproject.domain.todo.infrastructure.entity.TodoItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : MongoRepository<TodoItem, String>
