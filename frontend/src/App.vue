<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { type ITodo, type ITodoUpdate } from './models/todoModels'
import TodoService from './services/todoService'

const todos = ref<ITodo[]>([])

const todoService = new TodoService()

const input_content = ref('')
const input_title = ref('')

onMounted(() => {
  loadTodos()
})

const addTodo = () => {
  if (input_title.value.trim() === '') {
    return
  }
  console.log('addTodo')
  todoService.createTodo({ title: input_title.value, text: input_content.value })
  loadTodos()
}

const loadTodos = () => {
  todos.value = []
  todoService
    .getAllTodos()
    .then((res) => {
      res.data.forEach((element: ITodo) => {
        console.log('element', element)
        todos.value.push(element)
      })
    })
    .catch((err) => {
      console.log('err', err)
    })
}

const completeTodo = (id: string) => {
  const updateTodo: ITodoUpdate = { title: null, text: null, isDone: true }
  todoService.updateTodo(id, updateTodo)
  loadTodos()
}

const deleteTodo = (id: string) => {
  todoService.deleteTodo(id)
  loadTodos()
}
</script>

<template>
  <main class="app">
    <section>
      <h2>Todo-App</h2>
      <div></div>
    </section>

    <section class="create-todo">
      <h3>CREATE A TODO</h3>
      <form @submit.prevent="addTodo">
        <h4>Here you can add a new Todo</h4>
        <input type="text" placeholder="e.g. meet friends" v-model="input_title" />
        <h4>Add a description to your Todo</h4>
        <input type="text" placeholder="e.g. get there by 10am" v-model="input_content" />
        <input type="submit" value="Add todo" />
      </form>
    </section>
    <section class="todo-list">
      <h3>List of all open todos</h3>
      <div
        class="todo-item"
        v-for="(todo, index) in todos.filter((todo) => todo.isDone === false)"
        :key="index"
      >
        <h4>{{ todo.title }}</h4>
        <p>{{ todo.text }}</p>
        <input type="submit" value="todo completed" @click="completeTodo(todo.id.toString())" />
      </div>
    </section>
    <section class="todo-list">
      <h3>List of all completed todos</h3>
      <div
        class="todo-item"
        v-for="(todo, index) in todos.filter((todo) => todo.isDone === true)"
        :key="index"
      >
        <h4>{{ todo.title }}</h4>
        <p>{{ todo.text }}</p>
        <input type="submit" value="delete todo" @click="deleteTodo(todo.id.toString())" />
      </div>
    </section>
  </main>
</template>
