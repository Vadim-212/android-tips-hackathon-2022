package com.terriconvalleyhackathon.wooppaytips.presentation.contract

import com.terriconvalleyhackathon.wooppaytips.data.model.AuthBody
import com.terriconvalleyhackathon.wooppaytips.data.model.BalanceResponseBody
import com.terriconvalleyhackathon.wooppaytips.presentation.base.BaseContract

interface AuthFragmentContract {
    interface View: BaseContract.BaseView {
        fun initializePresenter()
        fun onSuccess()
        fun onError()
//        fun balanceOnSuccess(balance: BalanceResponseBody)
//        fun balanceOnError()
    }

    interface Presenter: BaseContract.BasePresenter<View> {
        fun onButtonClickListener(body: AuthBody)
    }
}