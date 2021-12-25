package com.abusada.teachme.presentation.common.binding_adapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.abusada.teachme.presentation.common.extensions.clicks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@BindingAdapter("app:coroutineClick")
fun View.coroutineClick(onClick: () -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        clicks().collect {
            onClick.invoke()
        }
    }
}