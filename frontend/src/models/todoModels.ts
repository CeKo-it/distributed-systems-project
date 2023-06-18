export interface ITodoCreate {
  title: String
  text: String
}

export interface ITodoResponse {
  id: Number
  title: String
  text: String
  creationDate: Date
  isDone: Boolean
}

export interface ITodo {
  id: Number
  title: String
  text: String
  creationDate: Date
  isDone: Boolean
}

export interface ITodoUpdate {
  title: String | null
  text: String | null
  isDone: Boolean | null
}
