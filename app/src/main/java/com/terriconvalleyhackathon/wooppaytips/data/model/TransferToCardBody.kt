package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class TransferToCardBody: Parcelable {
    private var amount: Float
    private var mobileScripts: Boolean

    constructor(amount: Float, mobileScripts: Boolean) {
        this.amount = amount
        this.mobileScripts = mobileScripts
    }

    constructor(parcel: Parcel) {
        amount = parcel.readFloat()
        mobileScripts = parcel.readByte() != 0.toByte()
    }

    fun getAmount() = amount

    fun getMobileScripts() = mobileScripts

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(amount)
        parcel.writeByte(if (mobileScripts) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TransferToCardBody> {
        override fun createFromParcel(parcel: Parcel): TransferToCardBody {
            return TransferToCardBody(parcel)
        }

        override fun newArray(size: Int): Array<TransferToCardBody?> {
            return arrayOfNulls(size)
        }
    }


}