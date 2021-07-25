package com.example.codewarschallenge.data.api

import com.example.codewarschallenge.domain.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CodewarsApi {

    @GET("user")
    suspend fun getUser(@Path("user") user: String): Response<User>
}