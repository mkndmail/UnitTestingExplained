package com.example.treehouseapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(),MainActivityView {
    private lateinit var presenter: MainActivityPresenter
    lateinit var linearLayout: LinearLayout
    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var submitButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(this)
        linearLayout = findViewById(R.id.linearLayout)
        submitButton =findViewById(R.id.launchActivityButton)
        editText=findViewById(R.id.editText)
        spinner = findViewById(R.id.colorSpinner)
        // Setup Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.colors_array, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        editText.setOnEditorActionListener { tv, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = tv.text.toString()
                presenter.editTextUpdated(text)
            }
            false
        }

        spinner.onItemSelectedListener =
            object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    index: Int,
                    id: Long
                ) {
                   presenter.setBackgroundColor(index)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        submitButton.setOnClickListener {
            presenter.launchAnotherActivity(OtherActivity::class.java)
        }
    }

    override fun setBackgroundColor(color: Int) {
        linearLayout.setBackgroundColor(color)
    }

    override fun setTextOnTextView(stringText: String) {
        findViewById<TextView>(R.id.textView).text = stringText
    }

    override fun launchAnotherActivity(activity: Class<*>?) {
        val intent = Intent(this@MainActivity, activity)
        startActivity(intent)
    }
}