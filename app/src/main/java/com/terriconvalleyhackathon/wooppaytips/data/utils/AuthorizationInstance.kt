package com.terriconvalleyhackathon.wooppaytips.data.utils

import com.terriconvalleyhackathon.wooppaytips.data.model.AuthResponseBody

class AuthorizationInstance() {
    private var authResponseBody: AuthResponseBody? = null

    fun setAuthResponseBody(authResponseBody: AuthResponseBody) {
        this.authResponseBody = authResponseBody
    }

    fun getAuthResponseBody() = authResponseBody

    companion object {
        private var instance: AuthorizationInstance? = null

        fun getInstance(): AuthorizationInstance {
            if (this.instance == null)
                this.instance = AuthorizationInstance()
            return this.instance!!
        }
    }
}