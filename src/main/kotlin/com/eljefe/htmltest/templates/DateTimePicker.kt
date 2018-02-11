package com.eljefe.htmltest.templates

import kotlinx.html.*

fun DIV.dateTimePicker(name: String = "datetimepicker", block: DIV.() -> Unit) = div {
    id = name
    div("input-group date") {
        block()
        input {
            type = InputType.text
            classes = setOf("form-control")
            span("input-group-addon") {
                i("glyphicon glyphicon-calendar")
            }
        }
        script {
            type = ScriptType.textJavaScript
            unsafe {
                raw("\$(function() { \$(\"#$name .input-group.date\").datepicker({todayBtn: true, autoclose: true});});")
            }
        }
    }
}