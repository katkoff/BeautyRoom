package com.mdgroup.beautyroom.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar.Duration
import com.google.android.material.snackbar.Snackbar


fun View.snackbar(message: String, @Duration length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, length).show()
}

fun Fragment.snackbar(message: String, @Duration length: Int = Snackbar.LENGTH_SHORT) {
    requireView().snackbar(message, length)
}