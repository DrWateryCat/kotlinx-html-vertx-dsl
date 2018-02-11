package com.eljefe.htmltest.templates

import kotlinx.html.*

fun BODY.navbar(page: Int) = nav ("navbar navbar-expand-lg navbar-dark bg-dark") {
    a(classes = "navbar-brand", href = "#"){
        text("Todo List")
    }

    button {
        classes = setOf("navbar-toggler")
        type = ButtonType.button
        attributes["data-toggle"] = "collapse"
        attributes["data-target"] = "#navbarNav"
        attributes["aria-controls"] = "navbarNav"
        attributes["aria-expanded"] = "false"
        attributes["aria-label"] = "Toggle Navigation"

        span("navbar-toggler-icon")
    }

    div {
        classes = setOf("collapse", "navbar-collapse")
        id = "navbarNav"

        ul("navbar-nav"){
            li {
                classes = setOf("nav-item", if(page == 0) "active" else "")
                a {
                    classes = setOf("nav-link")
                    href = "/"

                    +"Home"
                    span("sr-only") {
                        +"(current)"
                    }
                }
            }
            li {
                classes = setOf("nav-item", if(page == 1) "active" else "")
                a {
                    classes = setOf("nav-link")
                    href = "/add"

                    +"Add"
                }
            }
        }
    }
}