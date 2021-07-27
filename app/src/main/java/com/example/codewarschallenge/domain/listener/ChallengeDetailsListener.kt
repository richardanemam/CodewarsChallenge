package com.example.codewarschallenge.domain.listener

import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.domain.model.CompleteChallengesData

interface ChallengeDetailsListener {
    fun onClickViewCompleteChallengeDetails(data: CompleteChallengesData)
    fun onClickViewAuthoredChallengeDetails(data: AuthoredChallengesData)
}