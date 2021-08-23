package com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivityCompleteChallengeDetailsBinding
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import com.example.codewarschallenge.mainapplication.MainApplication
import com.example.codewarschallenge.presentation.states.BundleState
import javax.inject.Inject

class CompleteChallengeDetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCompleteChallengeDetailsBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModel: CompleteChallengeDetailsViewModel
    private lateinit var data: CompleteChallengesData

    companion object {
        const val EXTRA_COMPLETE_CHALLENGE_DETAILS = "completeChallengeDetails"
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
            getString(R.string.complete_challenges_details_error_message),
            Toast.LENGTH_LONG
        ).show()
        finish()
    }

    private fun setExtras() {
        data =
            intent.getParcelableExtra<CompleteChallengesData>(EXTRA_COMPLETE_CHALLENGE_DETAILS) as CompleteChallengesData
    }

    private fun setUpViews() {
        setUpToolbar()
        bindViews()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbarChallengesDetailsScreenId)
        supportActionBar?.apply {
            setTitle(R.string.complete_challenges_details_toolbar_title)
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
        binding.tvChallengesDetailsSlug.text = data.slug
        binding.tvChallengesDetailsCompletedAt.text = data.completedAt
        bindLanguages()
    }

    private fun bindLanguages() {
        val languages = data.completedLanguages
        if (!languages.isNullOrEmpty()) {
            for (language in languages) {
                binding
                    .tvChallengesDetailsCompletedLanguages
                    .append(language + "\n")

            }
        }
    }
}