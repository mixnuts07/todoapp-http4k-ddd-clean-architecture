package com.todo


class TodoUseCase(private val todoPort: TodoPort)  {

    fun getTodo(id: String): Todo {
     return todoPort.getTodoById(id)
    }
}
