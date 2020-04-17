package com.github.trueddd.handy.databinding.common

import android.content.Context
import androidx.databinding.ViewDataBinding

val ViewDataBinding.context: Context
    get() = root.context