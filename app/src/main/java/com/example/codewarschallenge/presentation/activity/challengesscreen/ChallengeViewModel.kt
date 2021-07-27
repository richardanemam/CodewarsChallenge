package com.example.codewarschallenge.presentation.activity.challengesscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarschallenge.domain.usecase.ChallengeUseCase
import com.example.codewarschallenge.presentation.states.UsersAuthoredChallengeState
import com.example.codewarschallenge.presentation.states.UsersCompleteChallengeState
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(private val useCase: ChallengeUseCase): ViewModel() {

    private val completeChallengeState: MutableLiveData<UsersCompleteChallengeState> = MutableLiveData()
    val onCompleteChallengeState: LiveData<UsersCompleteChallengeState> = completeChallengeState

    private val authoredChallengeState: MutableLiveData<UsersAuthoredChallengeState> = MutableLiveData()
    val onAuthoredChallengeState: LiveData<UsersAuthoredChallengeState> = authoredChallengeState

    fun fetchCompleteChallenges(user: String) {
        viewModelScope.launch {
            val data = useCase.getCompleteChallengeData(user)
            if(!data.isNullOrEmpty()) {
                completeChallengeState.postValue(UsersCompleteChallengeState.UsersCompleteChallengeAvailable(data))
            }  else {
                completeChallengeState.postValue(UsersCompleteChallengeState.UsersCompleteChallengeUnavailable)
            }
        }
    }

    fun fetchAuthoredChallenges(user: String) {
        viewModelScope.launch {
            val data = useCase.getAuthoredChallengeData(user)
            if(!data.isNullOrEmpty()) {
                authoredChallengeState.postValue(UsersAuthoredChallengeState.UsersAuthoredChallengeAvailable(data))
            } else {
                authoredChallengeState.postValue(UsersAuthoredChallengeState.UsersAuthoredChallengeUnavailable)
            }
        }
    }
}