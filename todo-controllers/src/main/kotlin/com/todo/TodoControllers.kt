package com.todo

import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.lens.Query
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import javax.inject.Inject

class TodoControllers {
    @Inject
    lateinit var todoUseCase: TodoUseCase
    fun returnTodoObject(): RoutingHttpHandler {
        return  "/todo" bind GET to {
                val id = Query.required("id").extract(it)
                val todos = it.query(id)?.let { todoUseCase.getTodo(it) }
                Response(OK).body(todos?.title?.value.toString())
                }
    }
}