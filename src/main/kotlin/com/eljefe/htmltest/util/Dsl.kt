package com.eljefe.htmltest.util

import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.StaticHandler
import kotlinx.html.HTML
import kotlinx.html.html
import kotlinx.html.stream.appendHTML

fun Vertx.restApi(port: Int, block: Router.() -> Unit) {
    createHttpServer().restApi(this, block).listen(port) {
        if (it.succeeded()) println("Listening on port $port")
        else println("Failed: ${it.cause()}")
    }
}

fun HttpServer.restApi(vertx: Vertx, block: Router.() -> Unit): HttpServer {
    val router = Router.router(vertx)
    router.route("/static/*").handler(StaticHandler.create("static"))
    router.route().handler(BodyHandler.create())
    router.block()
    requestHandler {
        router.accept(it)
    }
    return this
}

fun Router.get(path: String, block: RoutingContext.() -> Unit) = get(path).handler(block)
fun Router.post(path: String, block: RoutingContext.() -> Unit) = post(path).handler(block)
fun Router.put(path: String, block: RoutingContext.() -> Unit) = put(path).handler(block)
fun Router.delete(path: String, block: RoutingContext.() -> Unit) = delete(path).handler(block)

fun <T: Any?> RoutingContext.send(future: Future<T>) {
    future.setHandler {
        if (it.succeeded()) {
            response().end(Json.encode(it.result()))
        } else {
            response().statusCode = 500
            response().end(it.cause().toString())
        }
    }
}

fun RoutingContext.html(block: HTML.() -> Unit) {
    response().end(buildString {
        appendln("<!DOCTYPE html>")
        appendHTML().html(block)
        appendln()
    })
}

