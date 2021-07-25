package com.example.codewarschallenge.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CodewarsUsersDao {
    @Query("SELECT * from user")
    suspend fun getUsers(): List<CodewarsUsersEntity>

    @Insert
    suspend fun insertUser(user: CodewarsUsersEntity)

    @Delete
    suspend fun deleteUser(user: CodewarsUsersEntity)
}