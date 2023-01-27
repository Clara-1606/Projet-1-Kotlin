package com.ynov.firstproject.quiz.result

import android.widget.ImageView
import com.ynov.firstproject.R

class ResultHelper {

    companion object {
        fun getResultFromScore(score: Int) : Pair<Int,Int> {
            return when(score){
                in 11..26 -> Pair(R.drawable.griffondor, R.string.griffondor)
                in 27..31 -> Pair(R.drawable.serdaigle, R.string.serdaigle)
                in 32..46 -> Pair(R.drawable.poufsouffle, R.string.poufsouffle)
                in 47..60 -> Pair(R.drawable.serpentard, R.string.serpentard)
                else -> Pair(R.drawable.moldus, R.string.moldu)
            }
        }
    }
}