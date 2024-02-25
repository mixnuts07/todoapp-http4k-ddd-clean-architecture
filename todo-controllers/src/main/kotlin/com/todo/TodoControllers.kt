package com.todo

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer
import javax.inject.Inject

class TodoControllers {
    @Inject
    lateinit var todoUseCase: TodoUseCase
    fun returnTodoObject(): RoutingHttpHandler {
        return  "/todo" bind GET to {
                val todos = todoUseCase.getTodo(it.query("id") ?: "")
                Response(OK).body(todos.title.value)
                }
    }
}