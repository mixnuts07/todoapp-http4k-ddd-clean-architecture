package com.todo

import org.ktorm.database.Database
import org.ktorm.dsl.from
import org.ktorm.dsl.select
import org.ktorm.dsl.where
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

class TodoDriver {

    fun findTodoById(id: String?): Todo {
        for(row in database.from(Todos).select()) {
            println(row[Todos.title])
        }
        TODO()
    }
}

val database = Database.connect("jdbc:mysql://localhost:3306/ktorm", user = "root", password = "root")

object Todos: Table<Nothing>("todos") {
    val id = int("id").primaryKey()
    val title = varchar("title")
    val description = varchar("description")
}


interface Todo: Entity<Todo> {
    companion object: Entity.Factory<Todo>()
    val id: Int
    var title: String
    var description: String
}