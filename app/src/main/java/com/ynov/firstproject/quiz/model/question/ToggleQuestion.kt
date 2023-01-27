package com.ynov.firstproject.quiz.model.question

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.ynov.firstproject.quiz.model.answer.Answer
import pl.droidsonroids.gif.GifImageView

class ToggleQuestion(label : String, answers : List<Answer>, private val image: Int) : Question(label, answers) {

    override fun buildAnswersWidgets(context: Context): View {
        val constraintLayout = ConstraintLayout(context)
        constraintLayout.id = View.generateViewId()

// Added Gif
        val gifImageView = GifImageView(context)
        gifImageView.id = View.generateViewId()
        gifImageView.setImageResource(image)
        gifImageView.tag = image
        constraintLayout.addView(gifImageView)

// Added constraints to place the image
        val gifConstraints = ConstraintSet()
        gifConstraints.clone(constraintLayout)
        gifConstraints.connect(gifImageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        gifConstraints.connect(gifImageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        gifConstraints.connect(gifImageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        gifConstraints.applyTo(constraintLayout)

// Added switch
        val switch = Switch(context)
        switch.id = View.generateViewId()
        constraintLayout.addView(switch)

// Added constraints to place the switch below the image
        val switchConstraints = ConstraintSet()
        switchConstraints.clone(constraintLayout)
        switchConstraints.connect(switch.id, ConstraintSet.TOP, gifImageView.id, ConstraintSet.BOTTOM)
        switchConstraints.connect(switch.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        switchConstraints.connect(switch.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        switchConstraints.applyTo(constraintLayout)

// Added text left
        val textLeft = TextView(context)
        textLeft.id = View.generateViewId()
        textLeft.text = answers[0].label
        constraintLayout.addView(textLeft)

// Added constraints to place the text to the left of the switch
        val textViewNonConstraints = ConstraintSet()
        textViewNonConstraints.clone(constraintLayout)
        textViewNonConstraints.connect(textLeft.id, ConstraintSet.TOP, switch.id, ConstraintSet.TOP)
        textViewNonConstraints.connect(textLeft.id, ConstraintSet.END, switch.id, ConstraintSet.START)
        textViewNonConstraints.connect(textLeft.id, ConstraintSet.BOTTOM, switch.id, ConstraintSet.BOTTOM)
        textViewNonConstraints.applyTo(constraintLayout)

        // Added text right
        val textRight = TextView(context)
        textRight.id = View.generateViewId()
        textRight.text = answers[1].label
        constraintLayout.addView(textRight)

// Added constraints to place the text to the right of the switch
        val textViewRightConstraints = ConstraintSet()
        textViewRightConstraints.clone(constraintLayout)
        textViewRightConstraints.connect(textRight.id, ConstraintSet.TOP, switch.id, ConstraintSet.TOP)
        textViewRightConstraints.connect(textRight.id, ConstraintSet.START, switch.id, ConstraintSet.END)
        textViewRightConstraints.connect(textRight.id, ConstraintSet.BOTTOM, switch.id, ConstraintSet.BOTTOM)
        textViewRightConstraints.applyTo(constraintLayout)

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            selectedAnswerValue = if (isChecked) {
                answers[0].value
            } else {
                answers[1].value
            }
        }

        return constraintLayout
    }
}