package com.mdgroup.beautyroom.ui

import android.content.res.Resources
import com.mdgroup.beautyroom.R


class ErrorHandler(
    private val resources: Resources
) {

    fun getErrorMessage(throwable: Throwable): String {
        // todo resolve user-friendly error message by throwable
        return resources.getString(R.string.error_unknown)
    }
}