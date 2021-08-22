package com.example.codewarschallenge.presentation.states

import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import com.example.codewarschallenge.domain.model.UserModel

sealed class SplashState {
    object OpenSearchScreenState : SplashState()
}

sealed class ProgressbarState {
    object Show: ProgressbarState()
    object Hide: ProgressbarState()
}

sealed class UserInfoState {
    data class OnUserInfoAvailable(val user: ArrayList<UserModel>) : UserInfoState()
    object OnUserInfoUnavailable: UserInfoState()
    object OnUserIsAlreadyOnList: UserInfoState()
}

sealed class UsersCompleteChallengeState {
    data class OnUsersCompleteChallengeAvailable(val usersCompleteChallengeData: List<CompleteChallengesData>): UsersCompleteChallengeState()
    object OnUsersCompleteChallengeUnavailable: UsersCompleteChallengeState()
}

sealed class UsersAuthoredChallengeState {
    data class UsersAuthoredChallengeAvailable(val usersAuthoredChallengeData: List<AuthoredChallengesData>): UsersAuthoredChallengeState()
    object UsersAuthoredChallengeUnavailable: UsersAuthoredChallengeState()
}

sealed class BundleState {
    object OnBundleOk: BundleState()
    object OnBundleNok: BundleState()
}