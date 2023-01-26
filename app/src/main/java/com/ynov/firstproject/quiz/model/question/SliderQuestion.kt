package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.view.View
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import com.ynov.firstproject.quiz.model.answer.Answer

class SliderQuestion(label : String, answers : List<Answer>) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val slider = RangeSlider(context)



        return slider
    }
}