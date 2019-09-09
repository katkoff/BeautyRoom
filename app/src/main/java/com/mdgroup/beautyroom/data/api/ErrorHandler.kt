package com.mdgroup.beautyroom.data.api

import android.content.res.Resources
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.data.api.model.ErrorApiModel
import okhttp3.ResponseBody
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException


class ErrorHandler(
    private val resources: Resources,
    private val gson: Gson
) {

    fun getErrorMessage(throwable: Throwable): String {
        //TODO: resolve user-friendly error message by throwable
        return getErrorMessageFromServer(throwable)
    }

    private fun getErrorMessageFromServer(throwable: Throwable) = try {
        val httpException = throwable as HttpException
        val responseBody: ResponseBody? = httpException.response()?.errorBody()
        parseErrorResponse(responseBody)
    } catch (e: ClassCastException) {
        Timber.w("Can't cast Throwable ${e.javaClass.simpleName} to HttpException")
        resources.getString(R.string.error_unknown)
    }

    private fun parseErrorResponse(responseBody: ResponseBody?): String {
        val defaultErrorString = resources.getString(R.string.error_unknown)

        if (responseBody == null) return defaultErrorString

        try {
            val errorApiModel = gson.fromJson(responseBody.charStream(), ErrorApiModel::class.java)
            return errorApiModel.errorMessageApiModel.message
        } catch (e: IOException) {
            Timber.w("Can't read response body")
        } catch (e: JsonSyntaxException) {
            Timber.w("Can't parse response body")
        }

        return defaultErrorString
    }
}