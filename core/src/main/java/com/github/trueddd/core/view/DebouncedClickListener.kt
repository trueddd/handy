package com.github.trueddd.core.view

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import java.time.Duration

class DebouncedClickListener(
    private val debounceDuration: Long,
    private val action: (v: View?) -> Unit
) : View.OnClickListener {

    @RequiresApi(Build.VERSION_CODES.O)
    constructor(
        debounceDuration: Duration,
        action: (v: View?) -> Unit
    ) : this(debounceDuration.toMillis(), action)

    private var lastExecution = 0L

    override fun onClick(p0: View?) {
        val now = System.currentTimeMillis()
        if (now - lastExecution > debounceDuration) {
            lastExecution = now
            action.invoke(p0)
        }
    }
}

fun View.setDebouncedClickListener(debounceDuration: Long, action: (v: View?) -> Unit) {
    setOnClickListener(DebouncedClickListener(debounceDuration, action))
}

@RequiresApi(Build.VERSION_CODES.O)
fun View.setDebouncedClickListener(debounceDuration: Duration, action: (v: View?) -> Unit) {
    setOnClickListener(DebouncedClickListener(debounceDuration, action))
}