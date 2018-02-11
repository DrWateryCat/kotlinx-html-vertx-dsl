package com.eljefe.htmltest.templates

import kotlinx.html.*

fun BODY.addTask() = div("container") {
    form {
        id = "addTaskForm"

        div("form-group row") {
            label {
                htmlFor = "todoTitle"
                classes = setOf("col-sm-2", "col-form-label")
                +"Task Name"
            }

            div("col-sm-10") {
                input {
                    type = InputType.text
                    classes = setOf("form-control")
                    id = "todoTitle"
                    placeholder = "Title"
                }
            }
        }

        div("form-group row") {
            label {
                htmlFor = "todoDesc"
                classes = setOf("col-sm-2", "col-form-label")
                +"Task Description"
            }

            div("col-sm-10") {
                input {
                    type = InputType.text
                    id = "todoDesc"
                    classes = setOf("form-control")
                    placeholder = "Description"
                }
            }
        }

        div("form-group row") {
            label {
                htmlFor = "todoDue"
                classes = setOf("col-sm-2", "col-form-label")
                +"Due Date"
            }

            div("col-sm-10") {
                dateTimePicker("todoDue") {
                }
            }
        }

        div("form-group row") {
            div("col-sm-10") {
                button {
                    type = ButtonType.submit
                    classes = setOf("btn", "btn-primary")
                    onClick = "javascript:post()"
                    +"Submit"
                }
            }
        }
    }

    script {
        type = ScriptType.textJavaScript
        src = "/static/scripts/AddTask.js"
    }
}