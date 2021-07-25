package com.example.codewarschallenge.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.codewarschallenge.domain.model.CodeChallenges
import com.example.codewarschallenge.domain.model.Ranks
import com.example.codewarschallenge.domain.model.User

@Entity(tableName = "user")
data class CodewarsUsersEntity(
    @PrimaryKey val userName: String?,
    val name: String?,
    val honor: Int?,
    val clan: String?,
    val leaderboardPosition: Int?,
    val skillsList: List<String>?,
    val ranks: Ranks?,
    val codeChallenges: CodeChallenges?
)

fun User.toCodewarsUserEntity(): CodewarsUsersEntity {
    return CodewarsUsersEntity(
        userName = this.userName,
        name = this.name,
        honor = this.honor,
        clan = this.clan,
        leaderboardPosition = this.leaderboardPosition,
        skillsList = this.skillsList,
        ranks = this.ranks,
        codeChallenges = this.codeChallenges
    )
}

fun CodewarsUsersEntity.toUser(): User {
    return User(
        userName = this.userName,
        name = this.name,
        honor = this.honor,
        clan = this.clan,
        leaderboardPosition = this.leaderboardPosition,
        skillsList = this.skillsList,
        ranks = this.ranks,
        codeChallenges = this.codeChallenges
    )
}