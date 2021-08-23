package com.example.codewarschallenge.data.db

import androidx.room.*

@Dao
interface UserInfoDAO {
    @Query("SELECT * FROM user")
    fun getUsersInfo(): List<UserInfoEntity>

    @Query("SELECT count(*) FROM user")
    suspend fun getNumberOfRecords(): Int

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getOldestUser(): UserInfoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserInfoEntity)

    @Delete
    fun delete(user: UserInfoEntity)
}