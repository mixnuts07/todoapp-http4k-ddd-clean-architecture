package com.todo


interface TodoPort {
    fun getTodoById(id: String?): Todo
}