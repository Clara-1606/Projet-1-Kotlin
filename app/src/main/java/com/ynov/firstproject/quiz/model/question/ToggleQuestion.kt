package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import com.ynov.firstproject.quiz.model.answer.Answer

class ToggleQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val switch = Switch(context)
        val layout = LinearLayout(context)
        val leftText = TextView(context)
        val rightText = TextView(context)

        leftText.text  = answers[0].label
        rightText.text = answers[1].label

        layout.addView(leftText)
        layout.addView(switch)
        layout.addView(rightText)

        return layout
        //TODO : Clean with key value pair input
    }
}