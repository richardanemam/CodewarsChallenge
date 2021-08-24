package com.example.codewarschallenge

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

abstract class BaseRobotTest {

    fun matchesTextDisplayed(text: String) =  onView(withText(text)).check(matches(isDisplayed()))
    fun performClick(resId: Int) = onView(withId(resId)).perform(click())
    fun performTypeText(resId: Int, text: String) = onView(withId(resId)).perform(typeText(text))


}