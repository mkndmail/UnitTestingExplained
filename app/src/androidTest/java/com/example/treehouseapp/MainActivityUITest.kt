package com.example.treehouseapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.isA
import org.hamcrest.Description
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Mukund Gururani, mukund.gururani@kelltontech.com on 5/24/2021
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        Intents.init()
    }

    @After
    fun tearDown(){
        Intents.release()
    }

    @Test
    fun editTextUpdatesTextView() {
        // Arrange
        val givenString = "test123";

        onView(withId(R.id.editText)).perform(typeText(givenString))

        // Act

        onView(withId(R.id.editText)).perform(pressImeActionButton())

        // Assert

        onView(withId(R.id.textView)).check(matches(withText(givenString)))
    }

    @Test
    fun spinnerUpdatesBackgroundColor() {
        // Arrange

        val givenColor = Color.GREEN
        val spinnerItemText = "Green"

        // Act

        onView(withId(R.id.colorSpinner)).perform(click())
        onData(allOf(isA(String::class.java), `is`(spinnerItemText))).perform(click())

        // Assert
        val backGroundColorMatcher: BoundedMatcher<View, LinearLayout> =
            object : BoundedMatcher<View, LinearLayout>(LinearLayout::class.java) {
                override fun describeTo(description: Description?) {
                    description?.appendText("Background color should equal to : $givenColor")
                }

                override fun matchesSafely(linearLayout: LinearLayout?): Boolean {
                  val actualColor=  (linearLayout?.background as ColorDrawable).color
                    return actualColor == givenColor
                }
            }

        onView(withId(R.id.linearLayout)).check(matches(backGroundColorMatcher))
    }

    @Test
    fun buttonLaunchesOtherActivity() {
        // Arrange
        val givenText = "Other Activity"

        // Act
        onView(withId(R.id.launchActivityButton)).perform(click())

        // Assert
        onView(withText(givenText)).check(matches(isDisplayed()))
    }


}