package com.ynov.firstproject.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.model.question.RadioQuestion
import com.ynov.firstproject.quiz.model.answer.Answer
import com.ynov.firstproject.quiz.model.question.CheckBoxQuestion
import com.ynov.firstproject.quiz.model.question.Question

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
            RadioQuestion(getString(R.string.question_profession), listOf (
                Answer(1, getString(R.string.answer_lawyer)),
                Answer(10, getString(R.string.answer_movie_star)),
                Answer(7, getString(R.string.answer_teacher)),
                Answer(4, getString(R.string.answer_author_novels)),
                Answer(1, getString(R.string.answer_company_manager)),
                Answer(7, getString(R.string.answer_landscaper)),
                Answer(7, getString(R.string.answer_craftsman)),
                Answer(10, getString(R.string.answer_butcher))
            ))
        )

        questions.add(
            CheckBoxQuestion(getString(R.string.question_boggart),
                    listOf (
                        Answer(1, getString(R.string.answer_snake)),
                        Answer(4, getString(R.string.answer_clown)),
                        Answer(7, getString(R.string.answer_spider)),
                        Answer(10, getString(R.string.answer_dementor))
                    )
            , 2) 
        )

        val currentQuestion = findViewById<TextView>(R.id.lastQuestionNumber)
        currentQuestion.text = questions.size.toString()
        updateNumberQuestion()

        showQuestion(questions[currentQuizIndex])
    }

    fun showQuestion(question : Question) {
        val textQuestion = findViewById<TextView>(R.id.questionContent)
        textQuestion.text = question.label
        val questionView = question.buildAnswersWidgets(applicationContext)

        findViewById<LinearLayout>(R.id.answerLayout).removeAllViews()
        findViewById<LinearLayout>(R.id.answerLayout).addView(questionView)

    }

    fun handleAnswer(view: View) {
        val quiz = questions.get(currentQuizIndex)
        currentQuizIndex++

        if (currentQuizIndex >= questions.size) {
            val intent = Intent(this, AnswerActivity::class.java)
            startActivity(intent)
        }
        else {
            showQuestion(questions[currentQuizIndex])
            updateNumberQuestion()
        }
    }

    fun updateNumberQuestion() {
        val currentQuestion = findViewById<TextView>(R.id.currentQuestion)
        currentQuestion.text = (currentQuizIndex+1).toString()

    }
}

