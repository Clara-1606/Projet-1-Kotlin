package com.ynov.firstproject.quiz.model.question

import android.R
import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.widget.doAfterTextChanged
import com.ynov.firstproject.quiz.model.answer.Answer
import java.util.*

class AutoCompleteQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val autoComplete = AutoCompleteTextView(context)
        val answersString = ArrayList<String>()

        answers.forEach { answer -> answersString.add(answer.label) }

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            context,
            R.layout.simple_spinner_item,
            answersString.toList()
        )

        ad.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        autoComplete.width = 700
//        val layoutParams = autoComplete.layoutParams
//        layoutParams.width = 400
//        autoComplete.layoutParams = layoutParams

        autoComplete.isFocusableInTouchMode = true
        autoComplete.doAfterTextChanged {  action ->
            if (action.toString().isNotBlank() && action.toString().isNotEmpty()){
                selectedAnswerValue = 0
            }
        }
        autoComplete.setAdapter(ad)

        return autoComplete
    }
}