package com.github.trueddd.handy.core

import java.util.*

fun Date.isToday(): Boolean {
    val today = Calendar.getInstance()
    val given = Calendar.getInstance().apply {
        time = this@isToday
    }
    return today.isSameDay(given)
}

fun Date.isYesterday(): Boolean {
    val today = Calendar.getInstance().apply {
        add(Calendar.DAY_OF_YEAR, -1)
    }
    val given = Calendar.getInstance().apply {
        time = this@isYesterday
    }
    return today.isSameDay(given)
}

fun Calendar.isSameYear(other: Calendar): Boolean {
    return this.get(Calendar.YEAR) == other.get(Calendar.YEAR)
}

fun Calendar.isSameDayOfYear(other: Calendar): Boolean {
    return this.get(Calendar.DAY_OF_YEAR) == other.get(Calendar.DAY_OF_YEAR)
}

fun Calendar.isSameDay(other: Calendar): Boolean {
    return this.isSameYear(other) && this.isSameDayOfYear(other)
}

/**
 * Returns number of days passed since epoch start and given date
 * @return number of days
 */
fun Date.days(): Long {
    return this.time / 86_400_000
}