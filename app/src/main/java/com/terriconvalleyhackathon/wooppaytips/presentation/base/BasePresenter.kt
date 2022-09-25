package com.terriconvalleyhackathon.wooppaytips.presentation.base

import com.terriconvalleyhackathon.wooppaytips.data.api.wooppay.ApiConnectionInstance
import com.terriconvalleyhackathon.wooppaytips.data.api.wooppay.ApiServiceImplementation

abstract class BasePresenter {
    protected val apiService = ApiServiceImplementation(ApiConnectionInstance.getInstance().getApi())
}