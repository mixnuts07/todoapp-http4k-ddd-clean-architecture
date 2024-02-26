package com.todo

import javax.inject.Inject


class TodoUseCase  {
    @Inject
    lateinit var todoPort: TodoPort

    fun getTodo(id: String?): Todo {
     return todoPort.getTodoById(id)
    }
}
