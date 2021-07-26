package com.example.codewarschallenge.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

   /* @Singleton
    @Provides
    fun provideDataBase(): CodewarsUsersDatabase {
        return Room.databaseBuilder(
            provideContext(),
            CodewarsUsersDatabase::class.java,
            "codewars_users_database"
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: CodewarsUsersDatabase): CodewarsUsersDao {
        return database.codewarsUserDao()
    }*/

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext
}