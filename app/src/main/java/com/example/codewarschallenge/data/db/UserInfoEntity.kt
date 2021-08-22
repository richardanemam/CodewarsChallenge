package com.example.codewarschallenge.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.codewarschallenge.domain.model.UserInfoModel

@Entity(tableName = "user")
data class UserInfoEntity(
        @PrimaryKey val userName: String,
        @ColumnInfo(name = "name") val name: String?,
        @ColumnInfo(name = "leader_board_position") val leaderBoardPosition: Int?,
        @ColumnInfo(name = "best_language") val bestLanguage: String?,
        @ColumnInfo(name = "best_language_score") val bestLanguageScore: Int?
)

fun UserInfoModel.toUserInfoEntity(): UserInfoEntity = UserInfoEntity(
        userName = this.userName,
        name = this.name,
        leaderBoardPosition = this.leaderBoardPosition,
        bestLanguage = this.bestLanguage,
        bestLanguageScore = this.bestLanguageScore
)


fun UserInfoEntity.toUserInfoModel(): UserInfoModel = UserInfoModel(
        userName = this.userName,
        name = this.name,
        leaderBoardPosition = this.leaderBoardPosition,
        bestLanguage = this.bestLanguage,
        bestLanguageScore = this.bestLanguageScore
)
