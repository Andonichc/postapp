package com.andonichc.postsapp.presentation.model

import android.os.Parcel
import android.os.Parcelable


data class PostPresentationModel(val id: Int,
                                 val title: String,
                                 val body: String,
                                 val userName: String,
                                 val avatarUrl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(body)
        parcel.writeString(userName)
        parcel.writeString(avatarUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostPresentationModel> {
        override fun createFromParcel(parcel: Parcel): PostPresentationModel {
            return PostPresentationModel(parcel)
        }

        override fun newArray(size: Int): Array<PostPresentationModel?> {
            return arrayOfNulls(size)
        }
    }
}