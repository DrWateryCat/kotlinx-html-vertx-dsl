package com.eljefe.htmltest.templates

import com.eljefe.htmltest.models.Task
import kotlinx.html.*

fun DIV.task(task: Task, index: Int, block: DIV.() -> Unit) = div("card") {
    block()
    div("card-body") {
        h5("card-title") {
            +task.title
        }
        h6("card-subtitle mb-2 text-muted") {
            +"Due ${task.due}"
        }
        p("card-text") {
            +task.desc
        }
        button {
            classes = setOf("btn", "btn-outline-danger")
            onClick = "javascript:del($index)"
            +"Delete"
        }
    }
}