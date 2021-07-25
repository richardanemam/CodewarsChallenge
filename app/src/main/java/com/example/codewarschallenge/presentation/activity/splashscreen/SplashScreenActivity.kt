package com.example.codewarschallenge.presentation.activity.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.codewarschallenge.R
import com.example.codewarschallenge.presentation.activity.searchscreen.SearchScreenActivity
import com.example.codewarschallenge.presentation.states.SplashState

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this)[SplashScreenViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        subscribeSplashScreen()
    }

    private fun subscribeSplashScreen() {
        viewModel.onSplashScreenState.observe(this, {
            when(it) {
                SplashState.OpenSearchScreenState -> navigateToSearchScreen()
                else -> handleError()
            }
        })
    }

    private fun navigateToSearchScreen() {
        finish()
        startActivity(Intent(this, SearchScreenActivity::class.java))
    }

    private fun handleError() {
        Toast.makeText(this, "Somethig went wrong, try again later", Toast.LENGTH_SHORT).show()
        finish()
    }
}