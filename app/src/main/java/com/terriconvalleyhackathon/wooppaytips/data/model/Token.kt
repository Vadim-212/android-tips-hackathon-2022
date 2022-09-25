package com.terriconvalleyhackathon.wooppaytips.data.model

class Token private constructor(private var token: String) {
    fun getToken() = token

    companion object {
        private var instance: Token? = null

        fun getInstance() = instance

        fun setToken(token: String) {
            instance = Token(token)
        }
    }
}