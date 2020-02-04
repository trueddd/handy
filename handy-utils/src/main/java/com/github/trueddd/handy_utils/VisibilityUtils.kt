package com.github.trueddd.handy_utils

import android.view.View

fun View.isGone() = visibility == View.GONE

fun View.isVisible() = visibility == View.VISIBLE

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}