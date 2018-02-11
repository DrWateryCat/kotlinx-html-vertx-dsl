package com.eljefe.htmltest

import com.eljefe.htmltest.models.Task
import java.util.concurrent.atomic.AtomicInteger

object Tasks {
    private val tasks = HashMap<Int, Task>()
    private val counter = AtomicInteger()

    fun get(id: Int) = tasks[id]
    fun getAll() = tasks.values.toList()

    fun put(task: Task): Int {
        tasks[counter.getAndIncrement()] = task
        return counter.get()
    }

    fun delete(id: Int) = tasks.remove(id)

    fun indexOf(task: Task) = tasks.values.indexOf(task)
}