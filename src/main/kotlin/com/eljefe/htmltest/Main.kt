package com.eljefe.htmltest

import com.eljefe.htmltest.models.Task
import com.eljefe.htmltest.templates.addTask
import com.eljefe.htmltest.templates.header
import com.eljefe.htmltest.templates.index
import com.eljefe.htmltest.templates.navbar
import com.eljefe.htmltest.util.*
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import kotlinx.html.*
import java.time.LocalDate

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val vertx = Vertx.vertx()
        Tasks.put(Task("test", "test", LocalDate.now()))

        vertx.restApi(3000) {
            get("/") {
                html {
                    header("Todo List")
                    body {
                        navbar(0)
                        index()
                    }
                }
            }

            get("/add") {
                html {
                    header("Add a task")
                    body {
                        navbar(1)
                        addTask()
                    }
                }
            }

            post("/api/todo") {
                val future = Future.future<Unit>()
                try {
                    val task = Task(
                            request().getParam("todoTitle"),
                            request().getParam("todoDesc"),
                            LocalDate.parse(request().getParam("todoDue"))
                    )

                    Tasks.put(task)
                    response().statusCode = 201
                    future.complete()
                } catch (e: Exception) {
                    future.fail(e)
                }

                send(future)
            }

            delete("/api/todo") {
                val id = request().getParam("id").toInt()
                Tasks.delete(id)
                response().statusCode = 200
                response().end()
            }
        }
    }
}