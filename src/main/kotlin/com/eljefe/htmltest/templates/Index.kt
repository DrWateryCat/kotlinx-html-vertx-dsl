package com.eljefe.htmltest.templates

import com.eljefe.htmltest.Tasks
import kotlinx.html.*

fun BODY.index() = div("container") {
    div("card-deck") {
        for (t in Tasks.getAll()) {
            task(t, Tasks.indexOf(t)) {
            }
        }

        script {
            type = ScriptType.textJavaScript
            src = "/static/scripts/index.js"
        }
    }
}