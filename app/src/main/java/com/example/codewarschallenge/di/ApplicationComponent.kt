package com.example.codewarschallenge.di

import com.example.codewarschallenge.presentation.activity.challengesscreen.ChallengesActivity
import com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen.CompleteChallengeDetailsActivity
import com.example.codewarschallenge.presentation.activity.searchscreen.SearchScreenActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun injection(searchScreenActivity: SearchScreenActivity)
    fun injection(challengesActivity: ChallengesActivity)
    fun injection(completeChallengeDetailsActivity: CompleteChallengeDetailsActivity)
}