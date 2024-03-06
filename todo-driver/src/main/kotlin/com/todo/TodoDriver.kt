package com.todo

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import org.jetbrains.exposed.sql.transactions.transaction

class TodoDriver {
    val db = Database.connect("jdbc:mysql://localhost:3306/test", driver = "com.mysql.cj.jdbc.Driver", user = "root", password = "root")

    fun findTodoById(id: String): Todo {
            val todo = Todos.select(Todos.id, Todos.title, Todos.description)
                .where { Todos.id eq id }
                .forEach { it ->
                    val id = it[Todos.id]
                    val title = it[Todos.title]
                    val description = it[Todos.description]
                }
    }
}

object Todos: Table("todos") {
    val id: Column<Int> = integer("id")
    val title: Column<String> = varchar("title", 100)
    val description: Column<String> = varchar("description", 200)

    override val primaryKey = PrimaryKey(id)
}