package com.todo

data class Todo(val id: Id, val title: Title, val description: Description){
}
data class Id(val value: Int?)
data class Title(val value: String?)

data class Description(val value: String?)
