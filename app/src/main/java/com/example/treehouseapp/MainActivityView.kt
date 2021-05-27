package com.example.treehouseapp

/**
 * Created by Mukund Gururani, mukund.gururani@kelltontech.com on 5/21/2021
 */
interface MainActivityView {

    fun setBackgroundColor(color:Int)

    fun setTextOnTextView(stringText:String)

    fun launchAnotherActivity(activity: Class<*>?)

}