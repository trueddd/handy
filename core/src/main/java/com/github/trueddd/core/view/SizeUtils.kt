package com.github.trueddd.core.view

import android.content.Context
import kotlin.math.roundToInt

fun Float.toPx(context: Context): Float = context.resources.displayMetrics.density * this

fun Int.toPx(context: Context): Int = (context.resources.displayMetrics.density * this).roundToInt()

fun Float.toDp(context: Context): Float = this / context.resources.displayMetrics.density

fun Int.toDp(context: Context): Int = (this / context.resources.displayMetrics.density).roundToInt()