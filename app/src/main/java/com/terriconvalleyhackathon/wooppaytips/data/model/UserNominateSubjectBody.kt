package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class UserNominateSubjectBody: Parcelable {
    private var phone: String
    private var viewType: String

    constructor(phone: String, viewType: String) {
        this.phone = phone
        this.viewType = viewType
    }

    constructor(parcel: Parcel) {
        phone = parcel.readString()!!
        viewType = parcel.readString()!!
    }

    fun getPhone() = phone

    fun getViewType() = viewType

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(phone)
        parcel.writeString(viewType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserNominateSubjectBody> {
        override fun createFromParcel(parcel: Parcel): UserNominateSubjectBody {
            return UserNominateSubjectBody(parcel)
        }

        override fun newArray(size: Int): Array<UserNominateSubjectBody?> {
            return arrayOfNulls(size)
        }
    }


}