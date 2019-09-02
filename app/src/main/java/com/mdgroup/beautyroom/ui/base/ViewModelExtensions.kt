package com.mdgroup.beautyroom.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

//TODO Если в обсервер прилетит null, то скорее всего будет NPE - исправить
fun <T> Fragment.bind(liveData: LiveData<T>, onChanged: (t: T) -> Unit) {
    liveData.observe(this.viewLifecycleOwner, Observer {
        onChanged(it)
    })
}