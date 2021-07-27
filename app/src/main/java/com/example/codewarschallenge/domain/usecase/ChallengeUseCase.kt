package com.example.codewarschallenge.domain.usecase

import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import javax.inject.Inject

class ChallengeUseCase @Inject constructor(private val repository: CodewarsRepository) {

    suspend fun getCompleteChallengeData(user: String): List<CompleteChallengesData>? {
        val usersCompleteChallenges = repository.getCompleteChallenge(user)
        if(usersCompleteChallenges.isSuccessful) {
            return usersCompleteChallenges.body()?.data
        }
        return null
    }

    suspend fun getAuthoredChallengeData(user: String): List<AuthoredChallengesData>? {
        val usersAuthoredChallenges = repository.getAuthoredChallenge(user)
        if(usersAuthoredChallenges.isSuccessful) {
            return usersAuthoredChallenges.body()?.data
        }
        return null
    }
}