package com.nikhil.anand.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //creating a binding object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton : Button = findViewById(R.id.done_button)
        doneButton.setOnClickListener({
            addNikname(it)
        })
    }

    private fun addNikname(view : View){
        val nikname : EditText = findViewById(R.id.nikname_edit)
        val displayNickname : TextView = findViewById(R.id.displayNikname_text)
        displayNickname.text = "Hello ${nikname.editableText.toString()}"

        //hide the button and edit text
        val doneButton : Button = findViewById(R.id.done_button)
        doneButton.visibility = View.GONE
        nikname.visibility = View.GONE

        //show the nickname
        displayNickname.visibility = View.VISIBLE

        //hide the soft keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}