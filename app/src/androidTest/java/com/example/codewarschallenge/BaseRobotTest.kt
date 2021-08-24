package com.example.codewarschallenge

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

abstract class BaseRobotTest {

    fun isTextDisplayed(text: String) =  onView(withText(text)).check(matches(isDisplayed()))

}