package com.example.codewarschallenge.presentation.activity.searchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarschallenge.domain.model.UserInfoModel
import com.example.codewarschallenge.domain.usecase.SearchScreenUseCase
import com.example.codewarschallenge.presentation.states.ProgressbarState
import com.example.codewarschallenge.presentation.states.UserInfoState
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(private val useCase: SearchScreenUseCase) :
        ViewModel() {

    private val userInfoState: MutableLiveData<UserInfoState> = MutableLiveData()
    val onUserInfoState: LiveData<UserInfoState> = userInfoState

    private val progressBarState: MutableLiveData<ProgressbarState> = MutableLiveData()
    val onProgressbarState: LiveData<ProgressbarState> = progressBarState

    fun fetchUserByName(name: String) {
        viewModelScope.launch {
            progressBarState.postValue(ProgressbarState.Show)
            if (name.isInfoCached(useCase.getUsers())) {
                userInfoState.postValue(UserInfoState.OnUserIsAlreadyOnList)
            } else {
                useCase.getNewUser(name)
                handleUsersAvailability(name)
            }
        }.invokeOnCompletion {
            progressBarState.postValue(ProgressbarState.Hide)
        }
    }

    fun fetchCachedUsers() {
        viewModelScope.launch {
            val users = useCase.getUsers()
            if (users.isNullOrEmpty()) {
                userInfoState.postValue(UserInfoState.OnEmptyCachedList)
            } else {
                userInfoState.postValue(UserInfoState.OnUserInfoAvailable(users))
            }
        }
    }

    fun getListOrderedByRank() {
        viewModelScope.launch {
            val listOrderedByRank = useCase.orderUserListByRank()
            if (listOrderedByRank != null) {
                userInfoState.postValue(UserInfoState.OnUserInfoAvailable(listOrderedByRank))
            }
        }
    }

    private fun handleUsersAvailability(user: String) {
        viewModelScope.launch {
            val users = useCase.getUsers()
            if (user.isInfoCached(users)) {
                userInfoState.postValue(UserInfoState.OnUserInfoAvailable(users))
            } else {
                userInfoState.postValue(UserInfoState.OnUserInfoUnavailable)
            }
        }
    }

    private fun String.isInfoCached(users: List<UserInfoModel>): Boolean {
        return users.find { it.userName == this } != null
    }
}