package com.example.codewarschallenge.presentation.completechallengedetailsscreen

import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.ViewInteraction
import com.example.codewarschallenge.BaseRobotTest
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.COMPLETED_AT
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.ID
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.NAME
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.SLUG
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen.CompleteChallengeDetailsActivity
import com.example.codewarschallenge.presentation.activity.completechallengedetailsscreen.CompleteChallengeDetailsActivity.Companion.EXTRA_COMPLETE_CHALLENGE_DETAILS

object CompleteChallengeDetailsActivityRobot {
    const val ID = "514b92a657cdc65150000006"
    const val NAME = "Multiples of 3 and 5"
    const val SLUG = "multiples-of-3-and-5"
    const val COMPLETED_AT = "2017-04-06T16:32:09Z"
    const val LANGUAGES = "javascript\n coffeescript\n ruby"
}

private fun getCompleteChallenges() = CompleteChallengesData(
        id = ID,
        name = NAME,
        slug = SLUG,
        completedAt = COMPLETED_AT,
        completedLanguages = getLanguages()
)

private fun getLanguages() = listOf( "javascript", "coffeescript", "ruby")

class CompleteChallengeDetailsActivityPrepare {
    fun launchActivity() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), CompleteChallengeDetailsActivity::class.java)
        intent.putExtra(EXTRA_COMPLETE_CHALLENGE_DETAILS, getCompleteChallenges())
        launchActivity<CompleteChallengeDetailsActivity>(intent = intent).apply {
            moveToState(Lifecycle.State.RESUMED)
        }
    }
}

class CompleteChallengeDetailsActivityValidate: BaseRobotTest() {
    fun String.isDisplayed(): ViewInteraction = matchesTextDisplayed(this)
}