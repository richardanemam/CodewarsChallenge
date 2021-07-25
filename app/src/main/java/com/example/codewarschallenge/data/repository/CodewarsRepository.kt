package com.example.codewarschallenge.data.repository

import com.example.codewarschallenge.data.api.CodewarsApi
import com.example.codewarschallenge.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CodewarsRepository {
    companion object {
        private const val BASE_USERS_URL = "https://www.codewars.com/api/v1/users/"
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_USERS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val service: CodewarsApi by lazy {
        retrofit.create(CodewarsApi::class.java)
    }

    suspend fun getUser(user: String): Response<User> {
        return withContext(Dispatchers.IO) {
            service.getUser(user)
        }
    }
}