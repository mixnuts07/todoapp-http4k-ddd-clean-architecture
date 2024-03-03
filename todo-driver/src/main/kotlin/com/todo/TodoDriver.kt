package com.todo

import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

class TodoDriver {

    fun findTodoById(id: String): Todo {
        val results = database
            .from(Todos)
            .select(Todos.title, Todos.description)
            .where{
                (Todos.id eq id.toInt())
            }
            .map {row ->
                Todo(
                    Id(row[Todos.id]),
                    Title(row[Todos.title]),
                    Description(row[Todos.description])
                )
            }
        return results[0]
    }
}

val database = Database.connect("jdbc:mysql://localhost:3306/ktorm", user = "root", password = "root")

object Todos: Table<Nothing>("todos") {
    val id = int("id").primaryKey()
    val title = varchar("title")
    val description = varchar("description")
}


//interface Todo: Entity<Todo> {
//    companion object: Entity.Factory<Todo>()
//    val id: Int
//    var title: String
//    var description: String
//}