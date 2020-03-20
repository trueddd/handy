package com.github.trueddd.handy.core

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration

class DebouncedAction(private val delay: Long = 0L) {

    @RequiresApi(Build.VERSION_CODES.O)
    constructor(duration: Duration) : this(duration.toMillis())

    private var lastExecution = 0L

    private var executions = 0
    private var skipped = 0

    operator fun invoke(block: () -> Unit) {
        execute(block)
    }

    fun execute(block: () -> Unit) {
        val now = System.currentTimeMillis()
        if (now - lastExecution >= delay) {
            lastExecution = now
            block.invoke()
            executions++
        } else {
            skipped++
        }
    }

    fun getNumberOfExecutions() = executions

    fun getNumberOfSkippedExecutions() = skipped
}