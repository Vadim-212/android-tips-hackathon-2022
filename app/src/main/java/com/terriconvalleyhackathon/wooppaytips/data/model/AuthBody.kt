package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class AuthBody : Parcelable {
    private var login: String
    private var password: String

    constructor(login: String, password: String) {
        this.login = login
        this.password = password
    }

    constructor(parcel: Parcel) {
        login = parcel.readString()!!
        password = parcel.readString()!!
    }

    fun getLogin() = login

    fun getPassword() = password

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AuthBody> {
        override fun createFromParcel(parcel: Parcel): AuthBody {
            return AuthBody(parcel)
        }

        override fun newArray(size: Int): Array<AuthBody?> {
            return arrayOfNulls(size)
        }
    }
}