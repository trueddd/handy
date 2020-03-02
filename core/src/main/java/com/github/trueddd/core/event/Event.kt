package com.github.trueddd.core.event

open class Event<T>(private val data: T) {

    private var isHandled = false

    fun get(): T? {
        return if (isHandled) {
            null
        } else {
            isHandled = true
            data
        }
    }

    fun requireData() = data
}

fun <T> T.toEvent() = Event(this)