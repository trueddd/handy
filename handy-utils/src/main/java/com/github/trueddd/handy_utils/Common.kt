package com.github.trueddd.handy_utils

inline fun <reified A, B, C> notNull(first: A?, second: B?, block: (p1: A, p2: B) -> C?): C? {
    return if (first != null && second != null) {
        block.invoke(first, second)
    } else null
}