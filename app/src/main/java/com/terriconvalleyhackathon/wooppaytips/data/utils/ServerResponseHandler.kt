package com.terriconvalleyhackathon.wooppaytips.data.utils

import android.util.Log
import com.terriconvalleyhackathon.wooppaytips.data.model.ResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServerResponseHandler<T>(private var callback: ResponseCallback<T>): Callback<T> {
    fun handleResponse(callback: ResponseCallback<T>, response: Response<T>) {
        if (response.isSuccessful)
            callback.onSuccess(response.body())
        else
            callback.onError()
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        handleResponse(callback, response)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        callback.onError()
    }

}