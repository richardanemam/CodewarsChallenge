package com.example.codewarschallenge.data.db

import androidx.room.*

@Dao
interface UserInfoDAO {
    @Query("SELECT * FROM user")
    suspend fun getUsersInfo(): List<UserInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: UserInfoEntity)

    @Delete
    fun delete(user: UserInfoEntity)
}