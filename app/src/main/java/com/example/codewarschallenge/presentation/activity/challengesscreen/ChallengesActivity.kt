package com.example.codewarschallenge.presentation.activity.challengesscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codewarschallenge.databinding.ActivityChallengesBinding

class ChallengesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityChallengesBinding.inflate(layoutInflater) }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(binding.root)
    }


}