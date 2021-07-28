package com.example.codewarschallenge.presentation.activity.searchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarschallenge.domain.model.UserModel
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

    private val users = ArrayList<UserModel>()
    private val usersOrderedByRank = ArrayList<UserModel>()

    fun fetchUserByName(name: String) {
        viewModelScope.launch {
            progressBarState.postValue(ProgressbarState.Show)
            val user = useCase.getUser(name)
            handleUsersAvailability(user)
        }.invokeOnCompletion {
            progressBarState.postValue(ProgressbarState.Hide)
        }
    }

    private fun handleUsersAvailability(user: UserModel?) {
        if (user != null) {
            orderUserListBySearch(user)
            userInfoState.postValue(UserInfoState.OnUserInfoAvailable(users))
        } else {
            userInfoState.postValue(UserInfoState.OnUserInfoUnavailable)
        }
    }

    private fun orderUserListBySearch(user: UserModel) {
        if (users.size < 5) {
            users.add(0, user)
        } else {
            users.removeLast()
            users.add(0, user)
        }
    }

    fun orderUserListByRank(): ArrayList<UserModel> {
        if(users.isNotEmpty() && users.size <= 5) {
            usersOrderedByRank.clear()
            usersOrderedByRank.addAll(users.sortedBy { it.leaderboardPosition })
        }
        return usersOrderedByRank
    }
}