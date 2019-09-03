package com.mdgroup.beautyroom.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//TODO: Если в обсервер прилетит null, то скорее всего будет NPE - исправить
fun <T> Fragment.bind(liveData: LiveData<T>, onChanged: (t: T) -> Unit) {
    liveData.observe(this.viewLifecycleOwner, Observer {
        onChanged(it)
    })
}

fun CoroutineScope.launchWithHandlers(
    progressHandler: (Boolean) -> Unit = {},
    errorHandler: (Throwable) -> Unit = {},
    block: suspend () -> Unit
) {
    launch {
        try {
            progressHandler.invoke(true)
            block.invoke()
            progressHandler.invoke(false)
        } catch (e: Exception) {
            progressHandler.invoke(false)
            errorHandler.invoke(e)
        }
    }
}