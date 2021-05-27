package com.example.treehouseapp

import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by Mukund Gururani, mukund.gururani@kelltontech.com on 5/21/2021
 */
class MainActivityPresenterTest {
    lateinit var presenter: MainActivityPresenter
    lateinit var view:MockedView

    inner class MockedView:MainActivityView{
        var text:String = ""
        override fun setBackgroundColor(color: Int) {

        }

        override fun setTextOnTextView(stringText: String) {
            text=stringText
        }

        override fun launchAnotherActivity(activity: Class<*>?) {

        }

    }
    @Before
    fun setUp(){
        view = MockedView()
        presenter = MainActivityPresenter(view)
    }

    @Test
    fun setBackgroundColor() {
//        Arrange


//        Act


//        Assert
    }

    @Test
    fun editTextUpdated() {
//        Arrange

        val testString = "test123"

//        Act

        presenter.editTextUpdated(testString)

//        Assert

        assertEquals(testString,view.text)
    }

    @Test
    fun launchAnotherActivity() {
//        Arrange


//        Act


//        Assert
    }
}