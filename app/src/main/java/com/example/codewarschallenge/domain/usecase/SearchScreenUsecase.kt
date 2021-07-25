package com.example.codewarschallenge.domain.usecase

import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.model.User

class SearchScreenUsecase(val repository: CodewarsRepository) {

    suspend fun getUser(username: String): User? {
        return repository.getUser(user = username).body()
    }


}