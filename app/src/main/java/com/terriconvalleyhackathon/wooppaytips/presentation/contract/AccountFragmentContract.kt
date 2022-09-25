package com.terriconvalleyhackathon.wooppaytips.presentation.contract

import com.terriconvalleyhackathon.wooppaytips.data.model.AuthBody
import com.terriconvalleyhackathon.wooppaytips.data.model.BalanceResponseBody
import com.terriconvalleyhackathon.wooppaytips.presentation.base.BaseContract

interface AccountFragmentContract {
    interface View: BaseContract.BaseView {
        fun initializePresenter()
        fun balanceOnSuccess(balance: BalanceResponseBody)
        fun balanceOnError()
    }

    interface Presenter: BaseContract.BasePresenter<View> {
        fun onButtonClickListener()
    }
}