package com.lucasnobile.myapp.presentation.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * LaptopUI model class.
 *
 * @author lucas.nobile
 */
data class LaptopUI(val title: String,
                    val description: String,
                    @SerializedName("image")
                    val imageUrl: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LaptopUI> {
        override fun createFromParcel(parcel: Parcel): LaptopUI {
            return LaptopUI(parcel)
        }

        override fun newArray(size: Int): Array<LaptopUI?> {
            return arrayOfNulls(size)
        }
    }
}