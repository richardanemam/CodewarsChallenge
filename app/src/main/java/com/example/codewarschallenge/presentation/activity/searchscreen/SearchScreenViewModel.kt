package com.example.codewarschallenge.presentation.activity.searchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.usecase.SearchScreenUsecase
import com.example.codewarschallenge.presentation.states.UserInfoState
import kotlinx.coroutines.launch

class SearchScreenViewModel: ViewModel() {
    val repository = CodewarsRepository()
    val usecase = SearchScreenUsecase(repository)

    private val userInfoState: MutableLiveData<UserInfoState> = MutableLiveData()
    val onUserInfoState: LiveData<UserInfoState> = userInfoState

    fun fetchUserByName(name: String) {
        viewModelScope.launch {
            val user = usecase.getUser(name)
            userInfoState.postValue(user?.let { UserInfoState.UserInfoAvailable(it) })
        }
    }
}