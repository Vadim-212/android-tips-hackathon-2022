package com.terriconvalleyhackathon.wooppaytips.data.api.wooppay

import com.terriconvalleyhackathon.wooppaytips.data.model.*
import com.terriconvalleyhackathon.wooppaytips.utils.AppConstants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("auth")
    fun auth(@Body body: AuthBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("registration/create-account")
    fun registrationCreateAccount(@Body body: RegistrationCreateAccountBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("registration/set-password")
    fun registrationSetPassword(@Body body: RegistrationSetPasswordBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @GET("balance")
    fun balance(@Header("Authorization") token: String): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("payment/transfer-to-card")
    fun transferToCard(@Body body: TransferToCardBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @GET("history/receipt/{receiptId}")
    fun receipt(@Path("receiptId") receiptId: Int): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @GET("history/receipt/pdf/{receiptId}")
    fun receiptPdf(@Path("receiptId") receiptId: Int): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @GET("history")
    fun history(@Query("done_from") doneFrom: String,
                @Query("done_to") doneTo: String,
                @Query("per-page") perPage: Int,
                @Query("expand") expand: String,
                @Query("status") status: String,
                @Query("type") type: String,
                @Query("page") page: Int): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("history/transaction/get-operations-data")
    fun getOperationsData(@Body body: GetOperationsDataBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("service/donate")
    fun createServiceDonate(@Body body: CreateServiceDonateBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @GET("service/donate")
    fun getServiceDonates(): Call<Any>

    // TODO: 10. Запрос списка полей и валидаторов для сервиса

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("auth/pseudo")
    fun pseudoAuth(@Body body: PseudoAuthBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("payment/transfer-new")
    fun paymentTransferNew(@Body body: PaymentTransferNewBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("payment/pay-from-card")
    fun paymentPayFromCard(@Body body: PaymentPayFromCardBody): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @GET("user/id-status")
    fun userIdStatus(): Call<Any>

    @Headers(
        AppConstants.DEFAULT_CONTENT_TYPE,
        AppConstants.DEFAULT_LANGUAGE,
        AppConstants.DEFAULT_TIME_ZONE,
        AppConstants.DEFAULT_PARTNER_NAME
    )
    @POST("user/nominate-subject")
    fun userNominateSubject(@Body body: UserNominateSubjectBody): Call<Any>
}
