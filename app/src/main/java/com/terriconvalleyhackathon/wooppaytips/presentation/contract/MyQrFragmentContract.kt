package com.terriconvalleyhackathon.wooppaytips.presentation.contract

import com.terriconvalleyhackathon.wooppaytips.data.model.BalanceResponseBody
import com.terriconvalleyhackathon.wooppaytips.presentation.base.BaseContract

interface MyQrFragmentContract {
    interface View: BaseContract.BaseView {
        fun initializePresenter()
    }

    interface Presenter: BaseContract.BasePresenter<View> {
        fun onButtonClickListener()
    }
}