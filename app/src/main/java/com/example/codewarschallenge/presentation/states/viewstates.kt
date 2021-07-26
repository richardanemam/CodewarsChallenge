package com.example.codewarschallenge.presentation.states

import com.example.codewarschallenge.domain.model.User

sealed class SplashState {
    object OpenSearchScreenState : SplashState()
}

sealed class ProgressbarState {
    object Show: ProgressbarState()
    object Hide: ProgressbarState()
}

sealed class UserInfoState {
    data class UserInfoAvailable(val user: User) : UserInfoState()
    object UserInfoUnavailable: UserInfoState()
}