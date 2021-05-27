package com.example.treehouseapp

import android.graphics.Color

/**
 * Created by Mukund Gururani, mukund.gururani@kelltontech.com on 5/21/2021
 */
class MainActivityPresenter(private var view: MainActivityView?) {


    fun setBackgroundColor(index: Int) {
        when(index){
            0-> view?.setBackgroundColor(Color.WHITE)
            1-> view?.setBackgroundColor(Color.MAGENTA)
            2-> view?.setBackgroundColor(Color.GREEN)
            3-> view?.setBackgroundColor(Color.CYAN)
        }
    }

    fun editTextUpdated(stringText: String) {
        view?.setTextOnTextView(stringText)
    }

    fun launchAnotherActivity(activity: Class<*>?) {
        view?.launchAnotherActivity(activity)
    }

}