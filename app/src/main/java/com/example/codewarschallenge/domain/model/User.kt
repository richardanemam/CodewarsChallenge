package com.example.codewarschallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("username") val userName: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("honor") val honor: Int?,
    @SerializedName("clan") val clan: String?,
    @SerializedName("leaderboardPosition") val leaderboardPosition: Int?,
    @SerializedName("skills") val skillsList: List<String>?,
    @SerializedName("ranks") val ranks: Ranks?,
    @SerializedName("codeChallenges") val codeChallenges: CodeChallenges?
): Parcelable

@Parcelize
data class Ranks(
    @SerializedName("overall") val overall: Overall?,
    @SerializedName("languages") val languages: Languages?
): Parcelable

@Parcelize
data class Overall(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class Languages(
    @SerializedName("javascript") val javaScript: JavaScript?,
    @SerializedName("ruby") val ruby: Ruby?,
    @SerializedName("coffescript") val coffeeScript: CoffeeScript?,
    @SerializedName("csharp") val cSharp: CSharp?,
    @SerializedName("python") val python: Python?,
    @SerializedName("java") val java: Java?,
    @SerializedName("go") val go: Go?,
    @SerializedName("haskell") val haskell: Haskell?,
    @SerializedName("cpp") val cpp: Cpp?
): Parcelable

@Parcelize
data class JavaScript(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable


@Parcelize
data class Ruby(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class CoffeeScript(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class CSharp(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class Python(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class Go(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class Java(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class Haskell(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class Cpp(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
): Parcelable

@Parcelize
data class CodeChallenges(
    @SerializedName("totalAuthored") val totalAuthored: Int?,
    @SerializedName("totalCompleted") val totalCompleted: Int?
): Parcelable