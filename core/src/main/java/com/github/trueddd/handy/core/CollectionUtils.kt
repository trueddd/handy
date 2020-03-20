package com.github.trueddd.handy.core

inline fun <reified T> Iterable<*>.filterWithType(predicate: (T) -> Boolean): Iterable<T> {
    return this.filterIsInstance<T>().filter(predicate)
}

inline fun <reified T> Iterable<*>.firstOrNullOfType(predicate: (T) -> Boolean): T? {
    return this.firstOrNull {
        if (it is T) {
            predicate.invoke(it)
        } else false
    } as? T
}