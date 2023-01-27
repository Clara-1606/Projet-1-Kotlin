package com.ynov.firstproject.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.model.answer.Answer
import com.ynov.firstproject.quiz.model.question.*

class QuizActivity : AppCompatActivity() {

    private var questions = ArrayList<Question>()
    var currentQuizIndex : Int = 0
    var totalPoint : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        createQuiz()
    }

    @SuppressLint("SetTextI18n")
    private fun createQuiz() {

        questions.add(
            CheckBoxQuestion(getString(R.string.question_profession), listOf (
                Answer(1, getString(R.string.answer_lawyer)),
                Answer(10, getString(R.string.answer_movie_star)),
                Answer(7, getString(R.string.answer_teacher)),
                Answer(4, getString(R.string.answer_author_novels)),
                Answer(1, getString(R.string.answer_company_manager)),
                Answer(7, getString(R.string.answer_landscaper)),
                Answer(7, getString(R.string.answer_craftsman)),
                Answer(10, getString(R.string.answer_butcher))
            ),2)
        )

        questions.add(
            SpinnerQuestion(getString(R.string.question_boggart),
                    listOf (
                        Answer(1, getString(R.string.answer_snake)),
                        Answer(4, getString(R.string.answer_clown)),
                        Answer(7, getString(R.string.answer_spider)),
                        Answer(10, getString(R.string.answer_dementor))
                    )
            )
        )

        questions.add(
            AutoCompleteQuestion("Do you like Hermione Granger ?",
                listOf (
                    Answer(10, "No"),
                    Answer(5, "Yes"),
                        ))
        )

        questions.add(
            ImageQuestion("Which creature is your favorite ? ",
                    mapOf(
                        Pair(R.drawable.ic_android_black_24dp, Answer(4, "Hippogriffe")),
                        Pair(R.drawable.baseline_10k_24, Answer(1, "Phoenix")),
                        Pair(R.drawable.baseline_3d_rotation_24, Answer(7, "Niffleur")),
                        Pair(R.drawable.baseline_4g_mobiledata_24, Answer(10, "Basilic"))
                    )
                )
        )

        val currentQuestion = findViewById<TextView>(R.id.lastQuestionNumber)
        currentQuestion.text = questions.size.toString()
        updateNumberQuestion()

        showQuestion(questions[currentQuizIndex])
    }

    private fun showQuestion(question : Question) {
        val textQuestion = findViewById<TextView>(R.id.questionContent)
        textQuestion.text = question.label
        val questionView = question.buildAnswersWidgets(applicationContext)
        val constraintLayout =  findViewById<ConstraintLayout>(R.id.answerLayout)

        constraintLayout.removeAllViews()
        questionView.id = View.generateViewId()

        constraintLayout.addView(questionView)

        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(questionView.id, ConstraintSet.TOP, constraintLayout.id, ConstraintSet.TOP)
        constraintSet.connect(questionView.id, ConstraintSet.BOTTOM, constraintLayout.id, ConstraintSet.BOTTOM)
        constraintSet.connect(questionView.id, ConstraintSet.LEFT, constraintLayout.id, ConstraintSet.LEFT)
        constraintSet.connect(questionView.id, ConstraintSet.RIGHT, constraintLayout.id, ConstraintSet.RIGHT)
        constraintSet.applyTo(constraintLayout)
    }

    fun handleAnswer(view: View) {
        currentQuizIndex++

        if (currentQuizIndex >= questions.size) {
            val intent = Intent(this, AnswerActivity::class.java)
            var resultValue = 0
            questions.forEach { q -> resultValue += q.selectedAnswerValue }
            Log.i("Test", resultValue.toString())
            intent.putExtra("RESULT", resultValue)
            startActivity(intent)
        }
        else {
            showQuestion(questions[currentQuizIndex])
            updateNumberQuestion()
        }
    }

    private fun updateNumberQuestion() {
        val currentQuestion = findViewById<TextView>(R.id.currentQuestion)
        currentQuestion.text = (currentQuizIndex+1).toString()

    }
}

