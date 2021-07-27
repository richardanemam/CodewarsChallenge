package com.example.codewarschallenge.presentation.activity.challengesscreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivityChallengesBinding
import com.example.codewarschallenge.mainapplication.MainApplication
import com.example.codewarschallenge.presentation.fragments.AuthoredChallengesFragment
import com.example.codewarschallenge.presentation.fragments.CompleteChallengesFragment
import com.example.codewarschallenge.presentation.states.BundleState
import com.example.codewarschallenge.presentation.states.UsersAuthoredChallengeState
import com.example.codewarschallenge.presentation.states.UsersCompleteChallengeState
import javax.inject.Inject

class ChallengesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityChallengesBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModel: ChallengeViewModel
    private lateinit var user: String

    companion object {
        const val EXTRA_USER_NAME = "username"
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(binding.root)

        (application as MainApplication).getApplicationComponent().injection(this)
        viewModel.validateBundle(intent)

        subscribeUI()
    }

    private fun subscribeUI() {
        subscribeBundle()
        subscribeCompleteChallenges()
        subscribeAuthoredChallenges()
    }

    private fun subscribeBundle() {
        viewModel.onBundleState.observe(this, {
            when(it) {
                BundleState.OnBundleOk -> onBundleOk()
                BundleState.OnBundleNok -> onBundleNok()
            }
        })
    }

    private fun subscribeCompleteChallenges() {
        viewModel.onCompleteChallengeState.observe(this, {
            when(it) {
                is UsersCompleteChallengeState.OnUsersCompleteChallengeAvailable -> {
                    navigateTo(
                        CompleteChallengesFragment.newInstance(it.usersCompleteChallengeData)
                    )
                }
                UsersCompleteChallengeState.OnUsersCompleteChallengeUnavailable -> {
                    handleError(getString(R.string.challenges_complete_error_message))
                }
            }
        })
    }

    private fun subscribeAuthoredChallenges() {
        viewModel.onAuthoredChallengeState.observe(this, {
            when(it) {
                is UsersAuthoredChallengeState.UsersAuthoredChallengeAvailable -> {
                    navigateTo(
                        AuthoredChallengesFragment.newInstance(it.usersAuthoredChallengeData)
                    )
                }
                UsersAuthoredChallengeState.UsersAuthoredChallengeUnavailable -> {
                    handleError(getString(R.string.challenges_authored_error_message))
                }
            }
        })
    }

    private fun onBundleOk() {
        setExtras()
        setUpViews()
    }

    private fun onBundleNok() {
        handleError(getString(R.string.challenges_error_message))
    }

    private fun setExtras() {
        user = intent.getStringExtra(EXTRA_USER_NAME) as String
    }

    private fun setUpViews() {
        binding.bnvChallengesMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_challenges_complete -> {
                    viewModel.fetchCompleteChallenges(user)
                }
                R.id.menu_challenges_authored -> {
                    viewModel.fetchAuthoredChallenges(user)
                }
            }
            true
        }
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.flChallengesContainer.id, fragment)
            .commit()
    }

    private fun handleError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
}