package com.example.codewarschallenge.presentation.completechallengedetailsscreen

import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.COMPLETED_AT
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.ID
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.LANGUAGES
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.NAME
import com.example.codewarschallenge.presentation.completechallengedetailsscreen.CompleteChallengeDetailsActivityRobot.SLUG
import org.junit.Test

class CompleteChallengeDetailsActivityTest {

    private fun prepare(func: CompleteChallengeDetailsActivityPrepare.() -> Unit) =
        CompleteChallengeDetailsActivityPrepare().apply(func)

    private fun validate(func: CompleteChallengeDetailsActivityValidate.() -> Unit) =
        CompleteChallengeDetailsActivityValidate().apply(func)

    @Test
    fun whenLauchingActivity_ItShouldDisplayText() {
        prepare {
            launchActivity()
            //runBlocking { delay(Long.MAX_VALUE) }
        }
        validate {
            ID.isDisplayed()
            NAME.isDisplayed()
            SLUG.isDisplayed()
            COMPLETED_AT.isDisplayed()
            //LANGUAGES.isDisplayed()
        }
    }
}