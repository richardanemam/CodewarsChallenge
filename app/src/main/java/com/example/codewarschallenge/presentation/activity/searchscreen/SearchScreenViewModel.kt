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

    private val users = ArrayList<UserModel>(5)
    private val usersOrderedByRank = ArrayList<UserModel>(5)

    companion object {
        private const val TOTAL_USERS_ON_LIST = 5
        private const val INDEX_ZERO = 0
    }

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
        if (user != null && !users.contains(user)) {
            orderUserListBySearch(user)
            userInfoState.postValue(UserInfoState.OnUserInfoAvailable(users))
        }else if(user != null && users.contains(user)) {
            userInfoState.postValue(UserInfoState.OnUserIsAlreadyOnList)
        } else {
            userInfoState.postValue(UserInfoState.OnUserInfoUnavailable)
        }
    }

    private fun orderUserListBySearch(user: UserModel) {
        if (users.size < TOTAL_USERS_ON_LIST) {
            users.add(INDEX_ZERO, user)
        } else {
            users.removeLast()
            users.add(INDEX_ZERO, user)
        }
    }

    fun orderUserListByRank(): ArrayList<UserModel> {
        if(users.isNotEmpty() && users.size <= TOTAL_USERS_ON_LIST) {
            usersOrderedByRank.clear()
            usersOrderedByRank.addAll(users.sortedBy { it.leaderboardPosition })
        }
        return usersOrderedByRank
    }
}