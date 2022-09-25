package com.terriconvalleyhackathon.wooppaytips.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BalanceResponseBody: Parcelable {
    @Expose
    private var active: Int
    @Expose
    private var blocked: Int
    @SerializedName("acc_base")
    private var accBase: Int
    @SerializedName("acc_commission")
    private var accCommission: Int

    constructor(active: Int, blocked: Int, accBase: Int, accCommission: Int) {
        this.active = active
        this.blocked = blocked
        this.accBase = accBase
        this.accCommission = accCommission
    }

    constructor(parcel: Parcel) {
        active = parcel.readInt()
        blocked = parcel.readInt()
        accBase = parcel.readInt()
        accCommission = parcel.readInt()
    }

    fun getActive() = active
    fun getBlocked() = blocked
    fun getAccBase() = accBase
    fun getAccCommission() = accCommission

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(active)
        parcel.writeInt(blocked)
        parcel.writeInt(accBase)
        parcel.writeInt(accCommission)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BalanceResponseBody> {
        override fun createFromParcel(parcel: Parcel): BalanceResponseBody {
            return BalanceResponseBody(parcel)
        }

        override fun newArray(size: Int): Array<BalanceResponseBody?> {
            return arrayOfNulls(size)
        }
    }


}