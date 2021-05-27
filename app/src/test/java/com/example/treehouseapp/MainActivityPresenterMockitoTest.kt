package com.example.treehouseapp

import android.graphics.Color
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Mukund Gururani, mukund.gururani@kelltontech.com on 5/21/2021
 */

@RunWith(MockitoJUnitRunner::class)
class MainActivityPresenterMockitoTest{

    lateinit var presenter: MainActivityPresenter

    @Mock
    lateinit var view: MainActivityView

    @Before
    fun setUp(){
        presenter = MainActivityPresenter(view)
    }

    @Test
    fun setBackgroundColor() {
//        Arrange
        val colorIndex = 2
        val givenColor = Color.GREEN

//        Act

        presenter.setBackgroundColor(colorIndex)

//        Assert

        Mockito.verify(view).setBackgroundColor(givenColor)

    }

    @Test
    fun editTextUpdated() {

//        Arrange

        val givenString = "Hello World"

//        Act

        presenter.editTextUpdated(givenString)

//        Assert

        Mockito.verify(view)!!.setTextOnTextView(givenString)
    }

    @Test
    fun launchAnotherActivity() {

//        Arrange
        val otherActivity = OtherActivity::class.java

//        Act
        presenter.launchAnotherActivity(otherActivity)

//        Assert

        Mockito.verify(view).launchAnotherActivity(otherActivity)
    }
}
