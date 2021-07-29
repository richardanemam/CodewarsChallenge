package com.example.codewarschallenge.presentation.activity.challengesscreen

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivityChallengesBinding
import com.example.codewarschallenge.domain.listener.ChallengeDetailsListener
import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import com.example.codewarschallenge.mainapplication.MainApplication
import com.example.codewarschallenge.presentation.activity.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivity
import com.example.codewarschallenge.presentation.activity.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivity.Companion.EXTRA_AUTHORED_CHALLENGE_DETAILS
import com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen.CompleteChallengeDetailsActivity
import com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen.CompleteChallengeDetailsActivity.Companion.EXTRA_COMPLETE_CHALLENGE_DETAILS
import com.example.codewarschallenge.presentation.fragments.AuthoredChallengesFragment
import com.example.codewarschallenge.presentation.fragments.CompleteChallengesFragment
import com.example.codewarschallenge.presentation.states.BundleState
import com.example.codewarschallenge.presentation.states.ProgressbarState
import com.example.codewarschallenge.presentation.states.UsersAuthoredChallengeState
import com.example.codewarschallenge.presentation.states.UsersCompleteChallengeState
import javax.inject.Inject

class ChallengesActivity : AppCompatActivity(), ChallengeDetailsListener {

    private val binding by lazy { ActivityChallengesBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModel: ChallengeViewModel
    private lateinit var user: String

    companion object {
        const val EXTRA_USER_NAME = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        (application as MainApplication).getApplicationComponent().injection(this)
        viewModel.validateBundle(intent)

        subscribeUI()
    }

    private fun subscribeUI() {
        subscribeBundle()
        subscribeCompleteChallenges()
        subscribeAuthoredChallenges()
        subscribeProgressbar()
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

    private fun subscribeProgressbar() {
        viewModel.onProgressbarState.observe(this, {
            when(it) {
                ProgressbarState.Show -> binding.pbChallenges.visibility = View.VISIBLE
                ProgressbarState.Hide -> binding.pbChallenges.visibility = View.GONE
            }
        })
    }

    private fun onBundleOk() {
        setExtras()
        setUpViews()
        viewModel.fetchCompleteChallenges(user)
    }

    private fun onBundleNok() {
        handleError(getString(R.string.challenges_error_message))
    }

    private fun setExtras() {
        user = intent.getStringExtra(EXTRA_USER_NAME) as String
    }

    private fun setUpViews() {
        setUpToolbar()
        setUpBottomNavigationBar()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbarSearchScreenId)
        val actionBar = supportActionBar
        actionBar?.apply {
            setTitle(R.string.challenges_toolbar_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setUpBottomNavigationBar() {
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
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

    override fun onClickViewCompleteChallengeDetails(data: CompleteChallengesData) {
        val intent = Intent(this, CompleteChallengeDetailsActivity::class.java)
        intent.putExtra(EXTRA_COMPLETE_CHALLENGE_DETAILS, data)
        startActivity(intent)
    }

    override fun onClickViewAuthoredChallengeDetails(data: AuthoredChallengesData) {
        val intent = Intent(this, AuthoredChallengeDetailsActivity::class.java)
        intent.putExtra(EXTRA_AUTHORED_CHALLENGE_DETAILS, data)
        startActivity(intent)
    }
}