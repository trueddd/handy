package com.github.trueddd.databinding.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity<DB: ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: DB

    @get:LayoutRes protected abstract val layoutRes: Int

    protected open fun afterCreate(savedInstanceState: Bundle?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performBinding(savedInstanceState)
        binding.executePendingBindings()
        afterCreate(savedInstanceState)
    }

    protected open fun performBinding(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }
}