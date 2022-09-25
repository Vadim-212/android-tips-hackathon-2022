package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class RegistrationSetPasswordBody: Parcelable {
    private var login: String
    private var password: String
    @SerializedName("activation_code")
    private var activationCode: String

    constructor(login: String, password: String, activationCode: String) {
        this.login = login
        this.password = password
        this.activationCode = activationCode
    }

    constructor(parcel: Parcel) {
        login = parcel.readString()!!
        password = parcel.readString()!!
        activationCode = parcel.readString()!!
    }

    fun getLogin() = login

    fun getPassword() = password

    fun getActivationCode() = activationCode

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(password)
        parcel.writeString(activationCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegistrationSetPasswordBody> {
        override fun createFromParcel(parcel: Parcel): RegistrationSetPasswordBody {
            return RegistrationSetPasswordBody(parcel)
        }

        override fun newArray(size: Int): Array<RegistrationSetPasswordBody?> {
            return arrayOfNulls(size)
        }
    }
}