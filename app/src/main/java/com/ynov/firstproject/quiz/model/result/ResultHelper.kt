package com.ynov.firstproject.quiz.model.result

import android.widget.ImageView

class ResultHelper {

    fun getResultFromScore(score: Int): String
    {
        when(score){
            in 11..26 -> return "Griffondor"
            in 57..70 -> return "Serpentard"
            in 27..41 -> return "Poufsouffle"
            in 42..56 -> return "Serdaigle"
            else -> return "Homeless"
        }
    }
}