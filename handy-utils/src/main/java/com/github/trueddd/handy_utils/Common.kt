package com.github.trueddd.handy_utils

fun <A, B, C> notNull(first: A?, second: B?, block: (p1: A, p2: B) -> C?): C? {
    return if (first != null && second != null) {
        block.invoke(first, second)
    } else null
}