package com.example.codewarschallenge.presentation.activity.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codewarschallenge.presentation.states.SplashState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel: ViewModel() {

    companion object {
        private const val MILI_SECONDS_TIME = 3_000L
    }

    private val splashScreenState: MutableLiveData<SplashState> = MutableLiveData()
    val onSplashScreenState: LiveData<SplashState> = splashScreenState


    init {
        GlobalScope.launch {
            delay(MILI_SECONDS_TIME)
            splashScreenState.postValue(SplashState.OpenSearchScreenState)
        }
    }
}