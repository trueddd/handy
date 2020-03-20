package com.github.trueddd.handy.core.recycler

/**
 * Interface that is used for comparing items in DiffUtil.ItemCallback.
 * Implement this interface in your class that represents item in list.
 */
interface ItemComparable<in T> {
    fun isItemTheSame(other: T): Boolean
    fun isContentTheSame(other: T): Boolean
}