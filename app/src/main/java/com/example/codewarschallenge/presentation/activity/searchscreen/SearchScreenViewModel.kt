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
            if (name.findUser(useCase.getUsers()) != null) {
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

    private fun handleUsersAvailability(user: String) {
        viewModelScope.launch {
            val users = useCase.getUsers()
            if (user.findUser(users) != null) {
                userInfoState.postValue(UserInfoState.OnUserInfoAvailable(users))
            } else {
                userInfoState.postValue(UserInfoState.OnUserInfoUnavailable)
            }
        }
    }

    private fun String.findUser(users: List<UserInfoModel>) = users.find { it.userName == this }

    fun getListOrderedByRank() {
        viewModelScope.launch {
            val listOrderedByRank = useCase.orderUserListByRank()
            if (listOrderedByRank != null) {
                userInfoState.postValue(UserInfoState.OnUserInfoAvailable(listOrderedByRank))
            }
        }
    }
}