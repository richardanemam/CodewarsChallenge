package com.example.codewarschallenge.domain.usecase

import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.model.UserModel
import javax.inject.Inject

class SearchScreenUseCase @Inject constructor(
    private val repository: CodewarsRepository
) {

    suspend fun getUser(username: String): UserModel? {
        val user = repository.getUser(username)

        if(user.isSuccessful) {
            return user.body()
        }

        return null
    }
}