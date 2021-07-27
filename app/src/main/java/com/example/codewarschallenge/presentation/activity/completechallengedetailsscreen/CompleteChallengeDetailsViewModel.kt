package com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen.CompleteChallengeDetailsActivity.Companion.EXTRA_COMPLETE_CHALLENGE_DETAILS
import com.example.codewarschallenge.presentation.states.BundleState
import javax.inject.Inject

class CompleteChallengeDetailsViewModel @Inject constructor() : ViewModel() {

    private val bundleState: MutableLiveData<BundleState> = MutableLiveData()
    val onBundleState: LiveData<BundleState> = bundleState

    fun validateBundle(intent: Intent?) {
        if (intent != null && checkExtras(intent)) {
            bundleState.value = BundleState.OnBundleOk
        } else {
            bundleState.value = BundleState.OnBundleNok
        }
    }

    private fun checkExtras(intent: Intent): Boolean {
        return intent.hasExtra(EXTRA_COMPLETE_CHALLENGE_DETAILS)
    }
}