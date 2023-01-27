package com.ynov.firstproject.quiz.model.question

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.view.setPadding
import com.bumptech.glide.Glide
import com.ynov.firstproject.R
import com.ynov.firstproject.R.*
import com.ynov.firstproject.quiz.model.answer.Answer
import java.nio.file.WatchEvent.Modifier


class ImageQuestion(label : String, private val answersMap : Map<Int,Answer>) : Question(label, answersMap.values.toList()) {


    @SuppressLint("ResourceAsColor")
    override fun buildAnswersWidgets(context: Context): View {
        val layout = GridLayout(context)

        layout.rowCount = answersMap.size / 2
        layout.columnCount = answersMap.size / 2

        for (answer in answersMap){


            val image  = ImageView(context)
            image.setImageResource(answer.key)
            image.tag = answer.key
            Glide.with(context)
                .load(answer.key)
                .override(500, 500)
                .into(image)
            image.setOnClickListener { it as ImageView
                selectedAnswerValue = answersMap[it.tag]?.value as Int

                clearImageBackgrounds(layout)
                it.setBackgroundColor(color.blue_700)
                it.setPadding(10)

            }
            layout.addView(image)
        }

        return layout
    }

    fun clearImageBackgrounds(layout: GridLayout){
        val childCount: Int = layout.childCount
        for (i in 0 until childCount) {
            val v: ImageView = layout.getChildAt(i) as ImageView
            v.background = null
        }
    }
}