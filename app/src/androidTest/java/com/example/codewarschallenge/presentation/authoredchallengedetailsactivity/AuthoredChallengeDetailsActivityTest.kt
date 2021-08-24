package com.example.codewarschallenge.presentation.authoredchallengedetailsactivity

import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.DESCRIPTION
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.ID
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.NAME
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.RANK
import com.example.codewarschallenge.presentation.authoredchallengedetailsactivity.AuthoredChallengeDetailsActivityRobot.RANK_NAME
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

class AuthoredChallengeDetailsActivityTest {

    private fun prepare(func: AuthoredChallengeDetailsActivityPrepare.() -> Unit) =
        AuthoredChallengeDetailsActivityPrepare().apply(func)

    private fun validate(func: AuthoredChallengeDetailsActivityValidate.() -> Unit) =
        AuthoredChallengeDetailsActivityValidate().apply(func)

    @Test
    fun whenLauchingActivity_ItShouldDisplayText() {
        prepare {
            launchActivity()
            //runBlocking { delay(Long.MAX_VALUE) }
        }
        validate {
            ID.isDisplayed()
            NAME.isDisplayed()
            DESCRIPTION.isDisplayed()
            RANK.isDisplayed()
            RANK_NAME.isDisplayed()
        }
    }
}