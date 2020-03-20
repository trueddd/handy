package com.github.trueddd.handy.databinding.base.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class DataBindingDialogFragment<DB: ViewDataBinding> : DialogFragment() {

    protected lateinit var binding: DB

    @get:LayoutRes protected abstract val layoutRes: Int

    protected open fun performBinding(inflater: LayoutInflater) {
        binding = DataBindingUtil.inflate(inflater, layoutRes, null, false)
    }

    protected open fun afterCreateView() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performBinding(inflater)
        afterCreateView()
        return binding.root
    }
}