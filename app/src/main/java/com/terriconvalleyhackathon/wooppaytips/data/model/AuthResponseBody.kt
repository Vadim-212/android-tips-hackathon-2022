package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthResponseBody: Parcelable {
    @Expose
    private var id: Long
    @Expose
    private var login: String
    @Expose
    private var country: Int
    @Expose
    private var token: String
    @Expose
    private var email: String
    @Expose
    private var identified: Int
    @SerializedName("resident_kz")
    private var residentKz: Boolean

    constructor(id: Long, login: String, country: Int, token: String, email: String, identified: Int, residentKz: Boolean) {
        this.id = id
        this.login = login
        this.country = country
        this.token = token
        this.email = email
        this.identified = identified
        this.residentKz = residentKz
    }

    constructor(parcel: Parcel) {
        id = parcel.readLong()
        login = parcel.readString()!!
        country = parcel.readInt()
        token = parcel.readString()!!
        email = parcel.readString()!!
        identified = parcel.readInt()
        residentKz = parcel.readByte() != 0.toByte()
    }

    fun getId() = id
    fun getLogin() = login
    fun getCountry() = country
    fun getToken() = token
    fun getEmail() = email
    fun getIdentified() = identified
    fun getResidentKz() = residentKz

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(login)
        parcel.writeInt(country)
        parcel.writeString(token)
        parcel.writeString(email)
        parcel.writeInt(identified)
        parcel.writeByte(if (residentKz) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AuthResponseBody> {
        override fun createFromParcel(parcel: Parcel): AuthResponseBody {
            return AuthResponseBody(parcel)
        }

        override fun newArray(size: Int): Array<AuthResponseBody?> {
            return arrayOfNulls(size)
        }
    }


}