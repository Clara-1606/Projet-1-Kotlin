package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.view.View
import com.ynov.firstproject.quiz.model.answer.Answer

abstract class Question(var label : String, var answers : List<Answer>) {

    var selectedAnswerValue = -1

    abstract fun buildAnswersWidgets(context: Context) : View
}