package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.model.answer.Answer

class RadioQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val radioGroup = RadioGroup(context)

        for (answer in answers) {
            val radioButton = RadioButton(context)
            radioButton.text = answer.label
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedAnswer = answers.find { a -> a.label == group.findViewById<RadioButton>(checkedId).text }
                selectedAnswerValue = selectedAnswer!!.value
            }
            radioGroup.addView(radioButton)
        }

        return radioGroup
    }

}