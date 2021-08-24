package com.example.codewarschallenge.presentation.searchscreen

import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.MEMBER_TITLE
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.RECENT_SEARCHES
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.RECENT_SEARCHES_WARNING
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.SEARCH
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

class SearchScreenActivityTest {

    private val server = MockWebServer()

    private fun prepare(func: SearchScreenActivityRobotPrepare.() -> Unit) =
        SearchScreenActivityRobotPrepare(server).apply(func)

    private fun execute(func: SearchScreenActivityRobotExecute.() -> Unit) =
        SearchScreenActivityRobotExecute().apply(func)

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
            MEMBER_TITLE.isDisplayed()
            SEARCH.isDisplayed()
            RECENT_SEARCHES.isDisplayed()
            //RECENT_SEARCHES_WARNING.isDisplayed()
        }
    }
}