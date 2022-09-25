package com.terriconvalleyhackathon.wooppaytips.presentation.presenter

import android.content.Context
import com.terriconvalleyhackathon.wooppaytips.data.model.*
import com.terriconvalleyhackathon.wooppaytips.data.utils.AuthorizationInstance
import com.terriconvalleyhackathon.wooppaytips.data.utils.ServerResponseHandler
import com.terriconvalleyhackathon.wooppaytips.data.utils.ServerResponseParser
import com.terriconvalleyhackathon.wooppaytips.presentation.base.BasePresenter
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.AuthFragmentContract

class AuthFragmentPresenter(var context: Context): BasePresenter(), AuthFragmentContract.Presenter, ResponseCallback<Any> {
    private var view: AuthFragmentContract.View? = null
    private var authBody: AuthBody? = null

    override fun onSuccess(obj: Any?) {
        val authResponse = ServerResponseParser.parseServerResponse<AuthResponseBody>(obj!!, AuthResponseBody::class.java)
        AuthorizationInstance.getInstance().setAuthResponseBody(authResponse)
        Token.setToken(authResponse.getToken())
        view!!.onSuccess()


//        apiService.balance(Token.getInstance()!!.getToken(), object : ResponseCallback<Any> {
//            override fun onSuccess(obj: Any?) {
//                val balanceResponseBody = ServerResponseParser.parseServerResponse<BalanceResponseBody>(obj!!, BalanceResponseBody::class.java)
//                view!!.balanceOnSuccess(balanceResponseBody)
//            }
//
//            override fun onError() {
//                view!!.balanceOnError()
//            }
//
//        })
    }

    override fun onError() {
        view!!.onError()
    }

    override fun onButtonClickListener(body: AuthBody) {
        val login = body.getLogin()
        val password = body.getPassword()
        // check number
        authBody = body
        apiService.auth(body, this)
    }

    override fun attach(view: AuthFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        view = null
    }
}