package com.example.codewarschallenge.data.repository

import com.example.codewarschallenge.data.api.CodeWarsApi
import com.example.codewarschallenge.domain.model.AuthoredChallengesModel
import com.example.codewarschallenge.domain.model.CompleteChallengesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CodeWarsRepository @Inject constructor(
        private val service: CodeWarsApi,
        private val userCache: CacheUserPolicyRepository
) {

    suspend fun getUser(userName: String) {
        withContext(Dispatchers.IO) {
            val user = service.getUser(userName)
            if (user.isSuccessful) userCache.put(user = user.body())
        }
    }

    suspend fun getAllUsers() = userCache.getAllUsers()

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