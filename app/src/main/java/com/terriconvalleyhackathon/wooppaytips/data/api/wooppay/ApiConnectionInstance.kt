package com.terriconvalleyhackathon.wooppaytips.data.api.wooppay

import com.terriconvalleyhackathon.wooppaytips.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnectionInstance() {
    private var api: ApiInterface

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        api = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_WOOPPAY_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    fun getApi(): ApiInterface = this.api

    companion object {
        private var apiConnectionInstance: ApiConnectionInstance? = null

        fun getInstance(): ApiConnectionInstance {
            if (apiConnectionInstance == null)
                apiConnectionInstance = ApiConnectionInstance()
            return apiConnectionInstance!!
        }
    }
}