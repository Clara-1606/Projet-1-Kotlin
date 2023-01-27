package com.ynov.firstproject.quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ynov.firstproject.R


class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        val v = findViewById<TextView>(R.id.resultView)
        v.text = intent.getIntExtra("RESULT", 0).toString()
    }
}