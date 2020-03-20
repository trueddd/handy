package com.github.trueddd.handy.core.recycler

import androidx.recyclerview.widget.DiffUtil

class DiffUtilItemCallback<T : ItemComparable<T>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isItemTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isContentTheSame(newItem)
    }
}

fun <T : ItemComparable<T>> diffList(): Lazy<DiffUtil.ItemCallback<T>> {
    return lazy(LazyThreadSafetyMode.NONE) { DiffUtilItemCallback<T>() }
}