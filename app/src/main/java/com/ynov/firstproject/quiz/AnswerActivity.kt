package com.ynov.firstproject.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.result.ResultHelper


class AnswerActivity : AppCompatActivity() {

    var comment : String? = null
    var name : String ="";
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

    fun add (view: View) {
        if (comment == null) {
            var editComment = findViewById<EditText>(R.id.editText)
            var resultComment = findViewById<TextView>(R.id.comment)
            comment = editComment.text.toString();
            resultComment.text = editComment.text
            val buttonAdd = findViewById<Button>(R.id.buttonAdd)
            buttonAdd.isEnabled = false;
            Toast.makeText(this, R.string.text_toast_ok, Toast.LENGTH_LONG).show()
            editComment.setText("")
            editComment.isEnabled = false
        }
        else {
            Toast.makeText(this, R.string.text_toast_error_comment, Toast.LENGTH_LONG).show()
        }


    }
}