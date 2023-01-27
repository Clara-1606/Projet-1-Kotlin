package com.ynov.firstproject.quiz

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.result.ResultHelper


class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        val textResult = findViewById<TextView>(R.id.result)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val score = intent.getIntExtra("RESULT", 0)
        val (image, result) = ResultHelper.getResultFromScore(score)
        val name = intent.getStringExtra("NAME")
        imageView.setImageResource(image)

        textResult.text = getString(R.string.text_win) + name +  " " + getString(R.string.text_be) + getString(result) + " !!"

    }
}