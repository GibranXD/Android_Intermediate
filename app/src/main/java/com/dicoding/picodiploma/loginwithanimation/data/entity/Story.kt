package com.dicoding.picodiploma.loginwithanimation.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class Story(
    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "avatar_url")
    var photoUrl: String? = null,

    @ColumnInfo(name = "description")
    var desc: String? = null,
) : Parcelable
