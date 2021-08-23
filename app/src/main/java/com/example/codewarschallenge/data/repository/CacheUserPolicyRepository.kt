package com.example.codewarschallenge.data.repository

import com.example.codewarschallenge.data.db.UserInfoDAO
import com.example.codewarschallenge.data.db.toUserInfoEntity
import com.example.codewarschallenge.data.db.toUserInfoModel
import com.example.codewarschallenge.domain.helper.LanguagesMapHelper
import com.example.codewarschallenge.domain.helper.MappedLanguages
import com.example.codewarschallenge.domain.model.UserInfoModel
import com.example.codewarschallenge.domain.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CacheUserPolicyRepository @Inject constructor(private val userInfoDAO: UserInfoDAO) {

    companion object {
        private const val MAX_RECORDS = 5
    }

    suspend fun put(user: UserModel?) {
        deleteExtraRecords()
        user?.toUserInfo()?.toUserInfoEntity()?.let { userInfoDAO.insert(it) }
    }

    private suspend fun deleteExtraRecords() {
        while (userInfoDAO.getNumberOfRecords() >= MAX_RECORDS) {
            userInfoDAO.delete(userInfoDAO.getOldestUser())
        }
    }

    suspend fun getAllUsers(): List<UserInfoModel>{
        return withContext(Dispatchers.IO) {
            val users = mutableListOf<UserInfoModel>()
            userInfoDAO.getUsersInfo().forEach {
                users.add(it.toUserInfoModel())
            }
            users
        }
    }

    private fun UserModel.toUserInfo(): UserInfoModel {
        val bestLanguages = getBestLanguage(this)
        return UserInfoModel(
                userName = this.userName,
                name = this.name,
                leaderBoardPosition = this.leaderBoardPosition,
                bestLanguage = bestLanguages?.languageName,
                bestLanguageScore = bestLanguages?.score
        )
    }

    private fun getBestLanguage(userModel: UserModel?): MappedLanguages? = userModel
            ?.ranks
            ?.languages
            ?.let { LanguagesMapHelper.getBestLanguage(it) }
}