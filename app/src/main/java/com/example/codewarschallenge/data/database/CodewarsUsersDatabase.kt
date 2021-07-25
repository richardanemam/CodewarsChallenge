package com.example.codewarschallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CodewarsUsersEntity::class], version = 1)
abstract class CodewarsUsersDatabase: RoomDatabase() {
    abstract fun codewarsUserDao(): CodewarsUsersDao
}