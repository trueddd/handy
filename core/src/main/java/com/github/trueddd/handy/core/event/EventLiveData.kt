package com.github.trueddd.handy.core.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias EventLiveData<T> = LiveData<Event<T>>

typealias MutableEventLiveData<T> = MutableLiveData<Event<T>>