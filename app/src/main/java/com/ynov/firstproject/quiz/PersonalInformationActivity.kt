package com.ynov.firstproject.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.ynov.firstproject.R

class PersonalInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_informations)
    }

    fun startQuizz(view: View){
        val intent = Intent(this, QuizActivity::class.java)
        val textInput = findViewById<TextView>(R.id.inputName)
        if (textInput.text.isNotEmpty() && textInput.text.isNotBlank() )
        {
            intent.putExtra("NAME",textInput.text.toString())
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, R.string.answer_mandatory, Toast.LENGTH_SHORT).show()
        }


    }
}