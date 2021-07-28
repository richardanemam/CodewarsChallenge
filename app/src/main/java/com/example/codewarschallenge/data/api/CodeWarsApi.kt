package com.example.codewarschallenge.data.api

import com.example.codewarschallenge.domain.model.AuthoredChallengesModel
import com.example.codewarschallenge.domain.model.CompleteChallengesModel
import com.example.codewarschallenge.domain.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeWarsApi {

    @GET("{user}")
    suspend fun getUser(@Path("user") user: String): Response<UserModel>

    @GET("{user}/code-challenges/completed?page=0")
    suspend fun getCompletedChallenge(@Path("user") user: String): Response<CompleteChallengesModel>

    @GET("{user}/code-challenges/authored")
    suspend fun getAuthoredChallenge(@Path("user") user: String): Response<AuthoredChallengesModel>
}