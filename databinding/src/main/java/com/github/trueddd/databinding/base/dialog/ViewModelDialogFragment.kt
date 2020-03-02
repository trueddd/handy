package com.github.trueddd.databinding.base.dialog

import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

abstract class ViewModelDialogFragment<VM: AndroidViewModel, DB: ViewDataBinding> : DataBindingDialogFragment<DB>() {

    protected abstract val viewModel: VM

    protected abstract val viewModelId: Int

    override fun performBinding(inflater: LayoutInflater) {
        super.performBinding(inflater)
        binding.setVariable(viewModelId, viewModel)
    }
}