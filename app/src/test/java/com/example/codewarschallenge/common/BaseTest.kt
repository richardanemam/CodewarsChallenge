package com.example.codewarschallenge.common

import com.example.codewarschallenge.domain.model.AuthoredChallengesModel
import com.example.codewarschallenge.domain.model.CompleteChallengesModel
import com.example.codewarschallenge.domain.model.UserModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class BaseTest {

    fun getUser(): UserModel {
        val type = object : TypeToken<UserModel>() {}.type
        return Gson().fromJson(UsersJsonData.user, type)
    }

    fun getUsers() = arrayListOf(getUser())

    fun getCompleteChallenges(): CompleteChallengesModel {
        val type = object : TypeToken<CompleteChallengesModel>() {}.type
        return Gson().fromJson(UsersJsonData.completeChallenge, type)
    }

    fun getAuthoredChallenges(): AuthoredChallengesModel {
        val type = object : TypeToken<AuthoredChallengesModel>() {}.type
        return Gson().fromJson(UsersJsonData.authoredChallenge, type)
    }

    fun getCompleteChallengesData() = getCompleteChallenges().data
    fun getAuthoredChallengesData() = getAuthoredChallenges().data
}