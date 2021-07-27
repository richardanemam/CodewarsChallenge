package com.example.codewarschallenge.domain.listener

import com.example.codewarschallenge.domain.model.CompleteChallengesData

interface CompleteChallengeDetailsListener {
    fun onClickViewDetails(data: CompleteChallengesData)
}