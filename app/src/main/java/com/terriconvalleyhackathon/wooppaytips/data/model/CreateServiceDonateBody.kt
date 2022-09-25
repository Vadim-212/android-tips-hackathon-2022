package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable

class CreateServiceDonateBody: Parcelable {
    private var title: String
    private var name: String
    private var description: String
    private var fields: Fields

    constructor(title: String, name: String, description: String, fields: Fields) {
        this.title = title
        this.name = name
        this.description = description
        this.fields = fields
    }

    constructor(parcel: Parcel) {
        title = parcel.readString()!!
        name = parcel.readString()!!
        description = parcel.readString()!!
        fields = parcel.readParcelable(Fields::class.java.classLoader)!!
    }

    fun getTitle() = title

    fun getName() = name

    fun getDescription() = description

    fun getFields() = fields

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeParcelable(fields, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CreateServiceDonateBody> {
        override fun createFromParcel(parcel: Parcel): CreateServiceDonateBody {
            return CreateServiceDonateBody(parcel)
        }

        override fun newArray(size: Int): Array<CreateServiceDonateBody?> {
            return arrayOfNulls(size)
        }
    }


}