package com.example.codewarschallenge.presentation.activity.authoredchallengedetailsactivity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivityAuthoredChallengeDetailsBinding
import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.mainapplication.MainApplication
import com.example.codewarschallenge.presentation.states.BundleState
import javax.inject.Inject

class AuthoredChallengeDetailsActivity: AppCompatActivity() {

    private val binding by lazy { ActivityAuthoredChallengeDetailsBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModel: AuthoredChallengeDetailsViewModel
    lateinit var data: AuthoredChallengesData

    companion object {
        const val EXTRA_AUTHORED_CHALLENGE_DETAILS = "authoredChallengeDetails"
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
    }

    private fun subscribeBundle() {
        viewModel.onBundleState.observe(this, {
            when (it) {
                BundleState.OnBundleOk -> onBundleOk()
                BundleState.OnBundleNok -> onBundleNok()
            }
        })
    }

    private fun onBundleOk() {
        setExtras()
        setUpViews()
    }

    private fun onBundleNok() {
        Toast.makeText(
            this,
            getString(R.string.authored_challenges_details_error_message),
            Toast.LENGTH_LONG
        ).show()
        finish()
    }

    private fun setExtras() {
        data =
            intent.getParcelableExtra<AuthoredChallengesData>(EXTRA_AUTHORED_CHALLENGE_DETAILS) as AuthoredChallengesData
    }

    private fun setUpViews() {
        setUpToolbar()
        bindViews()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbarChallengesDetailsScreenId)
        val actionBar = supportActionBar
        actionBar?.apply {
            setTitle(R.string.authored_challenges_details_toolbar_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun bindViews() {
        binding.tvChallengesDetailsId.text = data.id
        binding.tvChallengesDetailsName.text = data.name
        binding.tvChallengesDetailsDescription.text = data.description
        binding.tvChallengesDetailsRankName.text = data.rank.toString()
        binding.tvChallengesDetailsRankName.text = data.rankName
        bindTags()
        bingLanguages()
    }

    private fun bindTags() {
        val tags = data.tags
        if (tags != null) {
            for (tag in tags) {
                binding.tvChallengesDetailsTags.append(tag + "\n")
            }
        }
    }

    private fun bingLanguages() {
        val languages = data.languages
        if (languages != null) {
            for (language in languages) {
                binding.tvChallengesDetailsLanguages.append(language + "\n")
            }
        }
    }
}