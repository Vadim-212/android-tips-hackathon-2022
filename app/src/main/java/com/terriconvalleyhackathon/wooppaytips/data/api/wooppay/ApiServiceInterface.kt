package com.terriconvalleyhackathon.wooppaytips.data.api.wooppay

import com.terriconvalleyhackathon.wooppaytips.data.model.AuthBody
import com.terriconvalleyhackathon.wooppaytips.data.model.ResponseCallback

interface ApiServiceInterface {
    fun auth(body: AuthBody, callback: ResponseCallback<Any>)

    fun balance(token: String, callback: ResponseCallback<Any>)
}