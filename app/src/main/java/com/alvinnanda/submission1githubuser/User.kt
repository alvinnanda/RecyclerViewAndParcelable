package com.alvinnanda.submission1githubuser
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String,
    var location: String,
    var photo: Int,
    var username: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String
): Parcelable