package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class RegistrationCreateAccountBody: Parcelable {
    private var login: String
    private var email: String

    constructor(login: String, email: String) {
        this.login = login
        this.email = email
    }

    constructor(parcel: Parcel) {
        login = parcel.readString()!!
        email = parcel.readString()!!
    }

    fun getLogin() = login

    fun getEmail() = email

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegistrationCreateAccountBody> {
        override fun createFromParcel(parcel: Parcel): RegistrationCreateAccountBody {
            return RegistrationCreateAccountBody(parcel)
        }

        override fun newArray(size: Int): Array<RegistrationCreateAccountBody?> {
            return arrayOfNulls(size)
        }
    }

}