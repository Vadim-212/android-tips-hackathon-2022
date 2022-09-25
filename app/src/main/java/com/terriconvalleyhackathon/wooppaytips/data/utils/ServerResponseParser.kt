package com.terriconvalleyhackathon.wooppaytips.data.utils

import com.google.gson.Gson
import java.lang.reflect.Type

class ServerResponseParser {
    companion object {
        fun <T> parseServerResponse(response: Any, type: Type): T {
            val gson = Gson()
            val json = gson.toJson(response)
            return gson.fromJson(json, type)
        }
    }
}