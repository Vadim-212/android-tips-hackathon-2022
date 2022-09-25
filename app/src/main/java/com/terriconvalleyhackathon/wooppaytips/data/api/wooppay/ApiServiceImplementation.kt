package com.terriconvalleyhackathon.wooppaytips.data.api.wooppay

import com.terriconvalleyhackathon.wooppaytips.data.model.AuthBody
import com.terriconvalleyhackathon.wooppaytips.data.model.ResponseCallback
import com.terriconvalleyhackathon.wooppaytips.data.utils.ServerResponseHandler
import retrofit2.Call

class ApiServiceImplementation(var api: ApiInterface) : ApiServiceInterface {

    override fun auth(body: AuthBody, callback: ResponseCallback<Any>) {
        val call: Call<Any> = api.auth(body)
        val serverResponseHandler = ServerResponseHandler(callback)
        call.enqueue(serverResponseHandler)
    }

    override fun balance(token: String, callback: ResponseCallback<Any>) {
        val call: Call<Any> = api.balance(token)
        val serverResponseHandler = ServerResponseHandler(callback)
        call.enqueue(serverResponseHandler)
    }
}