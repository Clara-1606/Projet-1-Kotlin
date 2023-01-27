package com.ynov.firstproject.quiz.model.question

import android.R
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.ynov.firstproject.quiz.model.answer.Answer


class SpinnerQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val spinner = Spinner(context)
        val answersString = ArrayList<String>()

        answers.forEach { answer -> answersString.add(answer.label) }

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            context,
            R.layout.simple_spinner_item,
            answersString.toList()
        )

        ad.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        spinner.adapter = ad

        // Set selected value

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val v = view as TextView
                val selectedAnswer = answers.find { a -> a.label == v.text }
                selectedAnswerValue = selectedAnswer!!.value
            }

        }

        return spinner
    }
}