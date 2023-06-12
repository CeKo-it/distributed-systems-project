import axios from "axios";

interface ITodoCreate {
    title: String,
    text: String
}

interface ITodoRsponse {
    id: Number,
    title: String,
    text: String,
    creationDate: Date,
    isDone: Boolean
}

interface ITodoUpdate {
    title: String | null,
    text: String | null,
    isDone: Boolean | null

}

const path = ""

export async function getAllTodos() {
    axios.get(path+"/todo-api/todos").then(
        (res) => {
            return res.data;
        }
    ).catch(
        err => {
            console.log(err);
        }
    )
}

async function createTodo(params:ITodoCreate) {
    
}