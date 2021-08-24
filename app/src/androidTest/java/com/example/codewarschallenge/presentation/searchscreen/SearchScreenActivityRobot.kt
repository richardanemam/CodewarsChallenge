package com.example.codewarschallenge.presentation.searchscreen

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.ViewInteraction
import com.example.codewarschallenge.BaseRobotTest
import com.example.codewarschallenge.R
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.CLIENT_ERROR_RESPONSE_CODE
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.RESPONSE_BODY
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.SERVER_PORT
import com.example.codewarschallenge.presentation.searchscreen.SearchScreenActivityRobot.SUCCESSFUL_RESPONSE_CODE
import com.example.codewarschallenge.presentation.activity.searchscreen.SearchScreenActivity
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

object SearchScreenActivityRobot {
    const val SERVER_PORT = 8080
    const val SUCCESSFUL_RESPONSE_CODE = 200
    const val CLIENT_ERROR_RESPONSE_CODE = 404
    const val RESPONSE_BODY = "{\"username\":\"richardanemam\",\"name\":\"Richard Anemam\",\"honor\":544,\"clan\":\"some clan\",\"leaderboardPosition\":134,\"skills\":[\"ruby\",\"c#\",\".net\",\"javascript\",\"coffeescript\",\"nodejs\",\"rails\"],\"ranks\":{\"overall\":{\"rank\":-3,\"name\":\"3 kyu\",\"color\":\"blue\",\"score\":2116},\"languages\":{\"javascript\":{\"rank\":-3,\"name\":\"3 kyu\",\"color\":\"blue\",\"score\":1819},\"ruby\":{\"rank\":-4,\"name\":\"4 kyu\",\"color\":\"blue\",\"score\":1005},\"coffeescript\":{\"rank\":-4,\"name\":\"4 kyu\",\"color\":\"blue\",\"score\":870}}},\"codeChallenges\":{\"totalAuthored\":3,\"totalCompleted\":230}}"
    const val MEMBER_TITLE = "Members"
    const val SEARCH = "Search"
    const val RECENT_SEARCHES = "Recent searches"
    const val RECENT_SEARCHES_WARNING = "Looks like you do not have recent searches, search for users on codewars"
}

internal fun mockSuccessfulResponse(): MockResponse {
    return MockResponse()
        .setResponseCode(SUCCESSFUL_RESPONSE_CODE)
        .setBody(RESPONSE_BODY)
}

internal fun mockResponseError(): MockResponse {
    return MockResponse().setResponseCode(CLIENT_ERROR_RESPONSE_CODE)
}

class SearchScreenActivityRobotPrepare(private val server: MockWebServer) {
    fun setDispatcher() {
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    "/user" -> mockSuccessfulResponse()
                    else -> mockResponseError()
                }
            }
        }
    }

    fun startServer() = server.start(SERVER_PORT)
    fun closeServer() = server.close()

    internal fun initActivity() {
        launchActivity<SearchScreenActivity>().apply {
            moveToState(Lifecycle.State.RESUMED)
        }
    }
}

class SearchScreenActivityRobotExecute: BaseRobotTest() {
    fun clickSearchView(): ViewInteraction = performClick(R.id.sv_search_screen_search_member)
    fun typeSearchViewText(): ViewInteraction = performTypeText(R.id.sv_search_screen_search_member, "richardanemam\n")

}

class SearchScreenActivityRobotValidate: BaseRobotTest() {
    fun String.isDisplayed() = matchesTextDisplayed(this)
}