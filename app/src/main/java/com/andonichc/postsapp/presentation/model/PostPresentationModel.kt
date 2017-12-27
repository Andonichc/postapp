package com.andonichc.postsapp.presentation.model

import android.os.Parcel
import android.os.Parcelable


data class PostPresentationModel(val id: Int,
                                 val title: String,
                                 val body: String,
                                 val userName: String,
                                 val avatarUrl: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(title)
        writeString(body)
        writeString(userName)
        writeString(avatarUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PostPresentationModel> = object : Parcelable.Creator<PostPresentationModel> {
            override fun createFromParcel(source: Parcel): PostPresentationModel = PostPresentationModel(source)
            override fun newArray(size: Int): Array<PostPresentationModel?> = arrayOfNulls(size)
        }
    }
}