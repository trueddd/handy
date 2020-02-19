package com.github.trueddd.databinding.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class DataBindingFragment<DB: ViewDataBinding> : Fragment() {

    protected lateinit var binding: DB

    @get:LayoutRes protected abstract val layoutRes: Int

    protected open fun afterCreate(savedInstanceState: Bundle?) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performBinding(inflater, savedInstanceState)
        binding.executePendingBindings()
        afterCreate(savedInstanceState)
        return binding.root
    }

    protected open fun performBinding(inflater: LayoutInflater, savedInstanceState: Bundle?) {
        binding = DataBindingUtil.inflate(inflater, layoutRes, null, false)
    }
}