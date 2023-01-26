package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.ynov.firstproject.quiz.model.answer.Answer

class RadioQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context?): View {
        val radioGroup = RadioGroup(context)

        for (answer in answers) {
            val radioButton = RadioButton(context)
            radioButton.text = answer.label
            radioGroup.addView(radioButton)
        }

        return radioGroup
    }
}