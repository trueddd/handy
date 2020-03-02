package com.github.trueddd.core.event

import androidx.lifecycle.MutableLiveData

open class MutableEventLiveData<T> : MutableLiveData<Event<T>>()