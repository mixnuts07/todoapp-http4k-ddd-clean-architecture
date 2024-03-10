package com.todo

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class TodoDriver() {
    init {
        Database.connect("jdbc:mysql://localhost:3306/test", driver = "com.mysql.cj.jdbc.Driver", user = "root", password = "root")
    }
    fun findTodoById(id: String): Todo {
        val todos = TodosTable.selectAll().where { TodosTable.id eq id }.map {
        }
    }
}
object TodosTable: Table("todos") {
    val id: Column<Int> = integer("id")
    val title: Column<String> = varchar("title", 100)
    val description: Column<String> = varchar("description", 200)

    override val primaryKey = PrimaryKey(id)
}