package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class Fields: Parcelable {
    private var amount: Int

    constructor(amount: Int) {
        this.amount = amount
    }

    constructor(parcel: Parcel) {
        amount = parcel.readInt()
    }

    fun getAmount() = amount

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fields> {
        override fun createFromParcel(parcel: Parcel): Fields {
            return Fields(parcel)
        }

        override fun newArray(size: Int): Array<Fields?> {
            return arrayOfNulls(size)
        }
    }


}