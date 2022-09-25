package com.terriconvalleyhackathon.wooppaytips.data.model

interface ResponseCallback<T> {
    fun onSuccess(obj: T?)
    fun onError()
}