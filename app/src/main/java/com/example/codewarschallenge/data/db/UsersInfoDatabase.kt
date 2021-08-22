package com.example.codewarschallenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserInfoEntity::class], version = 1)
abstract class UsersInfoDatabase: RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDAO
}