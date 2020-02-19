package com.github.trueddd.databinding.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

abstract class ViewModelFragment<VM: AndroidViewModel, DB: ViewDataBinding> : DataBindingFragment<DB>() {

    protected abstract val viewModel: VM

    protected abstract val viewModelId: Int

    override fun performBinding(inflater: LayoutInflater, savedInstanceState: Bundle?) {
        super.performBinding(inflater, savedInstanceState)
        binding.setVariable(viewModelId, viewModel)
    }
}