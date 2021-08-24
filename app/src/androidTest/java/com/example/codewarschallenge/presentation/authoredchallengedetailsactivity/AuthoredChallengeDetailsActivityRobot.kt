package com.example.codewarschallenge.presentation.authoredchallengedetailsactivity

import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.ViewInteraction
import com.example.codewarschallenge.BaseRobotTest
import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.presentation.activity.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivity
import com.example.codewarschallenge.presentation.activity.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivity.Companion.EXTRA_AUTHORED_CHALLENGE_DETAILS
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.DESCRIPTION
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.ID
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.NAME
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.RANK_NAME
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.RANK_VALUE

object AuthoredChallengeDetailsActivityRobot {
    const val ID = "5571d9fc11526780a000011a"
    const val NAME = "The builder of things"
    const val DESCRIPTION = "For this kata you will be using some meta-programming ..."
    const val RANK = "3"
    const val RANK_NAME = "3 kyu"
    const val RANK_VALUE: Int = 3
}

private fun getAuthoredChallenges() = AuthoredChallengesData(
    id = ID,
    name = NAME,
    description = DESCRIPTION,
    rank = RANK_VALUE,
    rankName = RANK_NAME,
    tags = getTags(),
    languages = getLanguages()
)

private fun getTags() = listOf(
    "Algorithms", "Metaprogramming", "Programming Paradigms", "Advanced Language Features",
    "Fundamentals", "Domain Specific Languages", "Declarative Programming"
)

private fun getLanguages() = listOf("ruby", "javascript", "python", "coffeescript")

class AuthoredChallengeDetailsActivityPrepare {
    fun launchActivity() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), AuthoredChallengeDetailsActivity::class.java)
        intent.putExtra(EXTRA_AUTHORED_CHALLENGE_DETAILS, getAuthoredChallenges())
        launchActivity<AuthoredChallengeDetailsActivity>(intent = intent).apply {
            moveToState(Lifecycle.State.RESUMED)
        }
    }
}

class AuthoredChallengeDetailsActivityValidate: BaseRobotTest() {
    fun String.isDisplayed(): ViewInteraction = matchesTextDisplayed(this)
}