package com.ynov.firstproject.quiz.result

import android.widget.ImageView
import com.ynov.firstproject.R

class ResultHelper {

    companion object {
        fun getResultFromScore(score: Int) : Pair<Int,Int> {
            return when(score){
                in 11..26 -> Pair(R.drawable.griffondor, R.string.griffondor)
                in 27..41 -> Pair(R.drawable.serdaigle, R.string.serdaigle)
                in 42..56 -> Pair(R.drawable.poufsouffle, R.string.poufsouffle)
                in 57..70 -> Pair(R.drawable.serpentard, R.string.serpentard)
                else -> Pair(R.drawable.moldus, R.string.moldu)
            }
        }
    }
}