package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class GetOperationsDataBody: Parcelable {
    @SerializedName("operation_ids")
    private lateinit var operationIds: ArrayList<String>

    constructor(operationIds: ArrayList<String>) {
        this.operationIds = operationIds
    }

    constructor(parcel: Parcel) {
        operationIds = parcel.readArrayList(null) as ArrayList<String>
    }

    fun getOperationIds() = operationIds

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeList(operationIds)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GetOperationsDataBody> {
        override fun createFromParcel(parcel: Parcel): GetOperationsDataBody {
            return GetOperationsDataBody(parcel)
        }

        override fun newArray(size: Int): Array<GetOperationsDataBody?> {
            return arrayOfNulls(size)
        }
    }


}