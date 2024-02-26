package com.todo

import javax.inject.Inject

open class TodoGateway: TodoPort {
    @Inject
    lateinit var todoDriver: TodoDriver
    override fun getTodoById(id: String?): Todo {
        TODO()
    }
}