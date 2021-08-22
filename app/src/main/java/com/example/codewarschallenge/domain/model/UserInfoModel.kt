package com.example.codewarschallenge.domain.model

data class UserInfoModel(
        val userName: String,
        val name: String?,
        val leaderBoardPosition: Int?,
        val bestLanguage: String?,
        val bestLanguageScore: Int?
)