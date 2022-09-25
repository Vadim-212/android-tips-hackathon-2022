package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class PaymentPayFromCardBody: Parcelable {
    @SerializedName("operation_id")
    private var operationId: Int

    constructor(operationId: Int) {
        this.operationId = operationId
    }

    constructor(parcel: Parcel) {
        operationId = parcel.readInt()
    }

    fun getOperationId() = operationId

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(operationId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PaymentPayFromCardBody> {
        override fun createFromParcel(parcel: Parcel): PaymentPayFromCardBody {
            return PaymentPayFromCardBody(parcel)
        }

        override fun newArray(size: Int): Array<PaymentPayFromCardBody?> {
            return arrayOfNulls(size)
        }
    }

}