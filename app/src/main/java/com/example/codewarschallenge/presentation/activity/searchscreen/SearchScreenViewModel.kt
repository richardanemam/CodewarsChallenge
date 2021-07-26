package com.example.codewarschallenge.presentation.activity.searchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarschallenge.domain.model.User
import com.example.codewarschallenge.domain.usecase.SearchScreenUseCase
import com.example.codewarschallenge.presentation.states.ProgressbarState
import com.example.codewarschallenge.presentation.states.UserInfoState
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(private val useCase: SearchScreenUseCase): ViewModel() {

    private val userInfoState: MutableLiveData<UserInfoState> = MutableLiveData()
    val onUserInfoState: LiveData<UserInfoState> = userInfoState

    private val progressBarState: MutableLiveData<ProgressbarState> = MutableLiveData()
    val onProgressbarState: LiveData<ProgressbarState> = progressBarState

    private val users = ArrayList<User>()

    fun fetchUserByName(name: String) {
        viewModelScope.launch {
            progressBarState.postValue(ProgressbarState.Show)
            val user = useCase.getUser(name)
            handleUsersAvailability(user)
        }.invokeOnCompletion {
            progressBarState.postValue(ProgressbarState.Hide)
        }
    }

    private fun handleUsersAvailability(user: User?) {
        if (user != null) {
            validateUserList(user)
            userInfoState.postValue(UserInfoState.UserInfoAvailable(users))
        } else {
            userInfoState.postValue(UserInfoState.UserInfoUnavailable)
        }
    }

    private fun validateUserList(user: User) {
        if(users.size < 5) {
           users.add(user)
        } else {
            users.removeFirst()
            users.add(user)
        }
    }
}