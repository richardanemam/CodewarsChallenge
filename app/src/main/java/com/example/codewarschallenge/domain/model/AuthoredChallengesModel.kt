package com.example.codewarschallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class AuthoredChallengesModel(
    @SerializedName("data") val data: List<AuthoredChallengesData>?
): Parcelable

@Parcelize
data class AuthoredChallengesData(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("rank") val rank: Int?,
    @SerializedName("rankName") val rankName: String?,
    @SerializedName("tags") val tags: List<String>?,
    @SerializedName("languages") val languages: List<String>?,
): Parcelable