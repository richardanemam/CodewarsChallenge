package com.example.codewarschallenge.common

import com.example.codewarschallenge.domain.model.AuthoredChallengesModel
import com.example.codewarschallenge.domain.model.CompleteChallengesModel
import com.example.codewarschallenge.domain.model.UserInfoModel
import com.example.codewarschallenge.domain.model.UserModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

open class BaseTest {

    fun getUser(): UserModel {
        val type = object : TypeToken<UserModel>() {}.type
        return Gson().fromJson(UsersJsonData.user, type)
    }

    fun getUsersInfo() = listOf(getUserInfo())
    fun geUsersAlreadyOnList() = listOf(getUserAlreadyOnList())
    fun getCompleteChallengesData() = getCompleteChallenges().data
    fun getAuthoredChallengesData() = getAuthoredChallenges().data
    fun getUserResponse(): Response<UserModel> = Response.success(getUser())
    fun getCompleteChallengeResponse(): Response<CompleteChallengesModel> = Response.success(getCompleteChallenges())
    fun getAuthoredResponse(): Response<AuthoredChallengesModel> = Response.success(getAuthoredChallenges())

    private fun getCompleteChallenges(): CompleteChallengesModel {
        val type = object : TypeToken<CompleteChallengesModel>() {}.type
        return Gson().fromJson(UsersJsonData.completeChallenge, type)
    }

    private fun getAuthoredChallenges(): AuthoredChallengesModel {
        val type = object : TypeToken<AuthoredChallengesModel>() {}.type
        return Gson().fromJson(UsersJsonData.authoredChallenge, type)
    }

    private fun getUserAlreadyOnList() = UserInfoModel(
            "richardcosta",
            "Richard Costa",
            9999,
            "kotlin",
            1000
    )

    private fun getUserInfo() = UserInfoModel(
            "richardanemam",
            "Richard Anemam",
            9999,
            "kotlin",
            1000
    )
}