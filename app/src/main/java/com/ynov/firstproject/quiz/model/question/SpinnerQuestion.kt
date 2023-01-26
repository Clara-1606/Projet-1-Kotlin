package com.ynov.firstproject.quiz.model.question

import android.R
import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.ynov.firstproject.quiz.model.answer.Answer


class SpinnerQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val spinner = Spinner(context)
        val answersString = ArrayList<String>()

        answers.forEach { answer -> answersString.add(answer.label) }

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            context as Context,
            R.layout.simple_spinner_item,
            answersString.toList()
        )

        ad.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        spinner.adapter = ad

        return spinner
    }
}