package com.example.codewarschallenge

import com.example.codewarschallenge.SearchScreenActivityRobot.MEMBER_TITLE
import com.example.codewarschallenge.SearchScreenActivityRobot.RECENT_SEARCHES
import com.example.codewarschallenge.SearchScreenActivityRobot.RECENT_SEARCHES_WARNING
import com.example.codewarschallenge.SearchScreenActivityRobot.SEARCH
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

class SearchScreenActivityTest {

    private val server = MockWebServer()

    private fun prepare(func: SearchScreenActivityRobotPrepare.() -> Unit) =
        SearchScreenActivityRobotPrepare(server).apply(func)

    private fun validate(func: SearchScreenActivityRobotValidate.() -> Unit) =
        SearchScreenActivityRobotValidate().apply(func)

    @Test
    fun whenLauchingActivity_ItShouldDisplayTexts() {
        prepare {
            setDispatcher()
            startServer()
            initActivity()
            closeServer()
        }
        validate {
            validateTexts(MEMBER_TITLE)
            validateTexts(SEARCH)
            validateTexts(RECENT_SEARCHES)
            validateTexts(RECENT_SEARCHES_WARNING)
        }
    }

    @Test
    fun whenLauchingActivity_ItShouldValidateSearch() {
        prepare {
            setDispatcher()
            startServer()
            initActivity()
            closeServer()
        }
        validate {
            validateSearch()
        }
    }
}