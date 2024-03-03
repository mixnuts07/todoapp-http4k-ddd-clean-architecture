package com.todo

import javax.inject.Inject

open class TodoGateway: TodoPort {
    @Inject
    private lateinit var todoDriver: TodoDriver
    override fun getTodoById(id: String?): Todo {
        return todoDriver.findTodoById(id)
    }
}