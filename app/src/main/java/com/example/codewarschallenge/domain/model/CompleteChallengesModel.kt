package com.example.codewarschallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompleteChallengesModel(
    @SerializedName("totalPages") val totalPages: Int?,
    @SerializedName("totalItems") val totalItems: Int?,
    @SerializedName("data") val data: List<CompleteChallengesData>?
): Parcelable

@Parcelize
data class CompleteChallengesData(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("completedAt") val completedAt: String?,
    @SerializedName("completedLanguages") val completedLanguages: List<String>?
): Parcelable
