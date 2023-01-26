package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.Spinner
import com.ynov.firstproject.quiz.model.answer.Answer

class CheckBoxQuestion(label : String, answers : List<Answer>, maxAnswerCount: Int) : Question(label, answers) {
    override fun buildAnswersWidgets(context: Context): View {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL

        for (answer in answers) {
            // Text
            val checkBox = CheckBox(context)
            checkBox.text = answer.label
            layout.addView(checkBox)
        }

        return layout
    }
}