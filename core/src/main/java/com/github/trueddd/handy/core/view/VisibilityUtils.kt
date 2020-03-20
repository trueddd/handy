package com.github.trueddd.handy.core.view

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

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

fun View.showKeyboard() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.hideKeyboard() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(windowToken, 0)
}