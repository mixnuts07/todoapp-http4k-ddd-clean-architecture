package com.todo

import org.ktorm.dsl.from
import org.ktorm.dsl.select
import org.ktorm.dsl.where
import org.ktorm.entity.Entity

class TodoDriver {

    fun findTodoById(id: String?): Todo {
        database
            .from(Todos)
            .select(Todo.id)
            .where { (Todo.id = id) }
    }
}

interface Todo: Entity<Todo> {
    companion object: Entity.Factory<Todo>()
    val id: Int
    var title: String
    var description: String
}