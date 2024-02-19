package com.todo

data class Todo(val id: Id, val title: Title){
}
data class Id(val value: String) {}
data class Title(val value: String) {}
