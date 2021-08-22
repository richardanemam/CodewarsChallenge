package com.example.codewarschallenge.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.codewarschallenge.data.api.CodeWarsApi
import com.example.codewarschallenge.data.db.UserInfoDAO
import com.example.codewarschallenge.data.db.UsersInfoDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    companion object {
        private const val BASE_USERS_URL = "https://www.codewars.com/api/v1/users/"
    }

    @Singleton
    @Provides
    fun provideDatabase(): UsersInfoDatabase {
        return Room.databaseBuilder(provideContext(), UsersInfoDatabase::class.java, "users_info_database").build()
    }

    @Singleton
    @Provides
    fun provideUserInfoDAO(): UserInfoDAO {
        return provideDatabase().userInfoDao()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_USERS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideService(): CodeWarsApi {
        return provideRetrofit().create(CodeWarsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext
}