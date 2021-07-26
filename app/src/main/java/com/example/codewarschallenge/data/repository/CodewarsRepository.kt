package com.example.codewarschallenge.data.repository

import com.example.codewarschallenge.data.api.CodewarsApi
import com.example.codewarschallenge.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CodewarsRepository @Inject constructor(private val service: CodewarsApi) {

    suspend fun getUser(user: String): Response<User> {
        return withContext(Dispatchers.IO) {
            service.getUser(user)
        }
    }
}