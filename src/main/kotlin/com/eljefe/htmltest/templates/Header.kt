package com.eljefe.htmltest.templates

import kotlinx.html.*

fun HTML.header(title: String) = head {
    title(content = title)
    link("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css", LinkRel.stylesheet)
    link("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css", LinkRel.stylesheet)
    script {
        src = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        type = ScriptType.textJavaScript
    }
    script {
        src = "http://code.jquery.com/jquery-3.3.1.min.js"
        type = ScriptType.textJavaScript
    }
    script {
        src = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"
        type = ScriptType.textJavaScript
    }
    meta {
        name = "viewport"
        content = "width=device-width, initial-scale=1.0"
    }
}