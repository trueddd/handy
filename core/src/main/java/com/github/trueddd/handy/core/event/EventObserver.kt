package com.github.trueddd.handy.core.event

import androidx.lifecycle.Observer

class EventObserver<T>(private val onChanged: (T) -> Unit) : Observer<Event<T>> {

    override fun onChanged(t: Event<T>?) {
        t?.get()?.let(onChanged)
    }
}