package com.example.codewarschallenge.data.repository

import com.example.codewarschallenge.data.api.CodeWarsApi
import com.example.codewarschallenge.domain.model.AuthoredChallengesModel
import com.example.codewarschallenge.domain.model.CompleteChallengesModel
import com.example.codewarschallenge.domain.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CodeWarsRepository @Inject constructor(private val service: CodeWarsApi) {

    suspend fun getUser(user: String): Response<UserModel> {
        return withContext(Dispatchers.IO) {
            service.getUser(user)
        }
    }

    suspend fun getCompleteChallenge(user: String): Response<CompleteChallengesModel> {
        return withContext(Dispatchers.IO) {
            service.getCompletedChallenge(user)
        }
    }

    suspend fun getAuthoredChallenge(user: String): Response<AuthoredChallengesModel> {
        return withContext(Dispatchers.IO) {
            service.getAuthoredChallenge(user)
        }
    }
}