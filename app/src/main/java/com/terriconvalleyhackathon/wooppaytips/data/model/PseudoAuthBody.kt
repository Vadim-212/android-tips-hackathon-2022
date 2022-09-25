package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class PseudoAuthBody: Parcelable {
    private var login: String

    constructor(login: String) {
        this.login = login
    }

    constructor(parcel: Parcel) {
        login = parcel.readString()!!
    }

    fun getLogin() = login

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PseudoAuthBody> {
        override fun createFromParcel(parcel: Parcel): PseudoAuthBody {
            return PseudoAuthBody(parcel)
        }

        override fun newArray(size: Int): Array<PseudoAuthBody?> {
            return arrayOfNulls(size)
        }
    }

}