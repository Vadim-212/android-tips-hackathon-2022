package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class PaymentTransferNewBody: Parcelable {
    @SerializedName("service_name")
    private var serviceName: String
    private var fields: Fields

    constructor(serviceName: String, fields: Fields) {
        this.serviceName = serviceName
        this.fields = fields
    }

    constructor(parcel: Parcel) {
        serviceName = parcel.readString()!!
        fields = parcel.readParcelable(Fields::class.java.classLoader)!!
    }

    fun getServiceName() = serviceName
    fun getFields() = fields

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(serviceName)
        parcel.writeParcelable(fields, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PaymentTransferNewBody> {
        override fun createFromParcel(parcel: Parcel): PaymentTransferNewBody {
            return PaymentTransferNewBody(parcel)
        }

        override fun newArray(size: Int): Array<PaymentTransferNewBody?> {
            return arrayOfNulls(size)
        }
    }


}