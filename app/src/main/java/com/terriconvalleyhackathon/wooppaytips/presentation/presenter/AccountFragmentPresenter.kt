package com.terriconvalleyhackathon.wooppaytips.presentation.presenter

import android.content.Context
import com.terriconvalleyhackathon.wooppaytips.data.model.*
import com.terriconvalleyhackathon.wooppaytips.data.utils.ServerResponseParser
import com.terriconvalleyhackathon.wooppaytips.presentation.base.BasePresenter
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.AccountFragmentContract
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.AuthFragmentContract

class AccountFragmentPresenter(var context: Context): BasePresenter(), AccountFragmentContract.Presenter,
    ResponseCallback<Any> {
    private var view: AccountFragmentContract.View? = null

    override fun onSuccess(obj: Any?) {
        val balanceResponse = ServerResponseParser.parseServerResponse<BalanceResponseBody>(obj!!, BalanceResponseBody::class.java)
        view!!.balanceOnSuccess(balanceResponse)
    }

    override fun onError() {
        view!!.balanceOnError()
    }

    override fun onButtonClickListener() {
        apiService.balance(Token.getInstance()!!.getToken(), this)
    }

    override fun attach(view: AccountFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        view = null
    }
}