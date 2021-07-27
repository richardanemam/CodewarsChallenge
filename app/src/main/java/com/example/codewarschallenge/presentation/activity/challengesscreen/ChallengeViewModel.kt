package com.example.codewarschallenge.presentation.activity.challengesscreen

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarschallenge.domain.usecase.ChallengeUseCase
import com.example.codewarschallenge.presentation.activity.challengesscreen.ChallengesActivity.Companion.EXTRA_USER_NAME
import com.example.codewarschallenge.presentation.states.BundleState
import com.example.codewarschallenge.presentation.states.ProgressbarState
import com.example.codewarschallenge.presentation.states.UsersAuthoredChallengeState
import com.example.codewarschallenge.presentation.states.UsersCompleteChallengeState
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(private val useCase: ChallengeUseCase): ViewModel() {

    private val completeChallengeState: MutableLiveData<UsersCompleteChallengeState> = MutableLiveData()
    val onCompleteChallengeState: LiveData<UsersCompleteChallengeState> = completeChallengeState

    private val authoredChallengeState: MutableLiveData<UsersAuthoredChallengeState> = MutableLiveData()
    val onAuthoredChallengeState: LiveData<UsersAuthoredChallengeState> = authoredChallengeState

    private val bundleState: MutableLiveData<BundleState> = MutableLiveData()
    val onBundleState: LiveData<BundleState> = bundleState

    private val progressBarState: MutableLiveData<ProgressbarState> = MutableLiveData()
    val onProgressbarState: LiveData<ProgressbarState> = progressBarState

    fun validateBundle(intent: Intent?) {
        if (intent != null && checkExtras(intent)) {
            bundleState.value = BundleState.OnBundleOk
        } else {
            bundleState.value = BundleState.OnBundleNok
        }
    }

    private fun checkExtras(intent: Intent): Boolean {
        return intent.hasExtra(EXTRA_USER_NAME)
    }

    fun fetchCompleteChallenges(user: String) {
        viewModelScope.launch {
            progressBarState.postValue(ProgressbarState.Show)
            val data = useCase.getCompleteChallengeData(user)
            if(!data.isNullOrEmpty()) {
                completeChallengeState.postValue(UsersCompleteChallengeState.OnUsersCompleteChallengeAvailable(data))
            }  else {
                completeChallengeState.postValue(UsersCompleteChallengeState.OnUsersCompleteChallengeUnavailable)
            }
        }.invokeOnCompletion {
            progressBarState.postValue(ProgressbarState.Hide)
        }
    }

    fun fetchAuthoredChallenges(user: String) {
        viewModelScope.launch {
            progressBarState.postValue(ProgressbarState.Show)
            val data = useCase.getAuthoredChallengeData(user)
            if(!data.isNullOrEmpty()) {
                authoredChallengeState.postValue(UsersAuthoredChallengeState.UsersAuthoredChallengeAvailable(data))
            } else {
                authoredChallengeState.postValue(UsersAuthoredChallengeState.UsersAuthoredChallengeUnavailable)
            }
        }.invokeOnCompletion {
            progressBarState.postValue(ProgressbarState.Hide)
        }
    }
}