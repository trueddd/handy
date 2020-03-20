package com.github.trueddd.handy.core.event

import androidx.lifecycle.MutableLiveData

open class MutableEventLiveData<T> : MutableLiveData<Event<T>>()