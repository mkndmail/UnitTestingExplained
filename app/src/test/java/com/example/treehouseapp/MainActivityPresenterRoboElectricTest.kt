package com.example.treehouseapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config


/**
 * Created by Mukund Gururani, mukund.gururani@kelltontech.com on 5/24/2021
 */

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [29])
class MainActivityPresenterRoboElectricTest {
    lateinit var mainActivity: MainActivity
    @Before
    fun setUp(){
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)

    }

    @Test
    fun editTextUpdatedText(){
        // Arrange
        val givenString = "test123"
        mainActivity.editText.setText(givenString)

        // Act
//        mainActivity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE)

        //Assert
        val actualString = mainActivity.editText.text.toString()
        assertEquals(givenString,actualString)
    }

    @Test
    fun spinnerUpdatesBackgroundColor(){

        //Arrange

        val index = 2
        val givenColor = Color.GREEN

        //Act

        mainActivity.spinner.setSelection(index)

        //Assert
        val expectedColor = (mainActivity.linearLayout.background as ColorDrawable).color

        assertEquals(givenColor,expectedColor)
    }

    @Test
    fun buttonClickStartActivity(){
        // Arrange
        val expectedIntent = Intent(mainActivity, OtherActivity::class.java)

        // Act

        mainActivity.submitButton.callOnClick()

        //Assert

        val actualIntent:Intent = shadowOf(RuntimeEnvironment.application).nextStartedActivity
//        assertEquals(expectedIntent,actualIntent)
//        assertEquals(expectedIntent.component, actualIntent.component)
        assertTrue(expectedIntent.filterEquals(actualIntent))
        }
    }