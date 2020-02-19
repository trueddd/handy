package com.github.trueddd.databinding.base.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

abstract class ViewModelActivity<VM: AndroidViewModel, DB: ViewDataBinding> : DataBindingActivity<DB>() {

    protected abstract val viewModel: VM

    protected abstract val viewModelId: Int

    override fun performBinding(savedInstanceState: Bundle?) {
        super.performBinding(savedInstanceState)
        binding.setVariable(viewModelId, viewModel)
    }
}