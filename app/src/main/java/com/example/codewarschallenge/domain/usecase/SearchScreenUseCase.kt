package com.example.codewarschallenge.domain.usecase

import com.example.codewarschallenge.data.repository.CodeWarsRepository
import com.example.codewarschallenge.domain.model.UserInfoModel
import javax.inject.Inject

class SearchScreenUseCase @Inject constructor(private val repository: CodeWarsRepository) {

    suspend fun getNewUser(username: String) {
        repository.getUser(username)
    }

    suspend fun orderUserListByRank(): List<UserInfoModel>? {
        val users = getUsers()
        if(!users.isNullOrEmpty()) {
            return users.sortedBy { it.leaderBoardPosition }
        }
        return null
    }

    suspend fun getUsers(): List<UserInfoModel> = repository.getAllUsers().asReversed()

}