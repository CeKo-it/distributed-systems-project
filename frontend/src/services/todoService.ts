import axios from 'axios'
import { type ITodoCreate, type ITodoUpdate } from '../models/todoModels'

class TodoService {
  private baseApi: string

  constructor() {
    const path = import.meta.env.VITE_BACKEND_API_PATH + ':' + import.meta.env.VITE_BACKEND_API_PORT
    this.baseApi = path + '/todo-api/'
  }

  async getAllTodos() {
    return axios.get(this.baseApi+'todos')
  }

  async createTodo(todo: ITodoCreate) {
    try {
      const res = await axios.post(this.baseApi+'todo', todo)
      return res.data
    } catch (err) {
      console.log(err)
    }
  }

  async deleteTodo(id: string) {
    try {
      const res = await axios.delete(`${this.baseApi}todo/${id}`)
      return res.data
    } catch (err) {
      console.log(err)
    }
  }

  async updateTodo(id: string, todo: ITodoUpdate) {
    try {
      const res = await axios.put(`${this.baseApi}todo/${id}`, todo)
      return res.data
    } catch (err) {
      console.log(err)
    }
  }
}

export default TodoService
