package com.github.trueddd.core.view

import android.view.View

fun View.isGone() = visibility == View.GONE

fun View.isVisible() = visibility == View.VISIBLE

/**
 * Sets visibility of view, where isVisible set to true means
 * that View.VISIBLE will be applied and View.GONE otherwise.
 */
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}