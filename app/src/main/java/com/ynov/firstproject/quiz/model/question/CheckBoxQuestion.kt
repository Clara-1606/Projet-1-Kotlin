package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.*
import com.ynov.firstproject.quiz.model.answer.Answer

class CheckBoxQuestion(label : String, answers : List<Answer>, private val maxAnswerCount: Int) : Question(label, answers) {

    var answersCount: Int = 0

    override fun buildAnswersWidgets(context: Context): View {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL

        for (answer in answers) {
            val checkBox = CheckBox(context)
            checkBox.text = answer.label
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    if (answersCount < maxAnswerCount)
                    {
                        answersCount++
                        val selectedAnswer = answers.find { a -> a.label == buttonView.text }
                        selectedAnswerValue += selectedAnswer!!.value
                    } else {
                        buttonView.isChecked = false
                    }
                }
                else if (maxAnswerCount > 0) {
                    answersCount--
                    val selectedAnswer = answers.find { a -> a.label == buttonView.text }
                    selectedAnswerValue -= selectedAnswer!!.value
                }
            }
            layout.addView(checkBox)
        }

        return layout
    }

    override fun resetQuestion() {
        super.resetQuestion()
        answersCount = 0
    }
}