package com.github.trueddd.databinding.base.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <DB: ViewDataBinding> Context.showDialog(
    @LayoutRes layoutRes: Int,
    @StyleRes styleRes: Int = 0,
    cancellable: Boolean = true,
    params: Map<Int, Any> = emptyMap(),
    afterCreate: ((dialog: AlertDialog, binding: DB) -> Unit) = { _, _ -> }
) {
    val builder = AlertDialog.Builder(this, styleRes)
    val binding = DataBindingUtil.inflate<DB>(LayoutInflater.from(this), layoutRes, null, false)
    params.forEach {
        binding.setVariable(it.key, it.value)
    }
    val dialog = builder
        .setView(binding.root)
        .setCancelable(cancellable)
        .create()
    dialog.show()
    afterCreate.invoke(dialog, binding)
}