package com.example.codewarschallenge.domain.usecase

import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.model.User
import javax.inject.Inject

class SearchScreenUseCase @Inject constructor(
    private val repository: CodewarsRepository
) {

    suspend fun getUser(username: String): User? {
        val user = repository.getUser(username)

        if(user.isSuccessful) {
            return user.body()
        }

        return null
    }
}