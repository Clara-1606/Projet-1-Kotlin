package com.ynov.firstproject.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.answer.CheckBoxFragment
import com.ynov.firstproject.quiz.answer.SpinnerFragment
import com.ynov.firstproject.quiz.model.Quiz
import com.ynov.firstproject.quiz.model.answer.Answer
import com.ynov.firstproject.quiz.model.answer.GroupAnswers

class QuizActivity : AppCompatActivity() {

    private var quizzes = ArrayList<Quiz>()
    var currentQuizIndex : Int = 0
    var totalPoint : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        createQuiz()



    }

    @SuppressLint("SetTextI18n")
    private fun createQuiz() {
        quizzes.add(
            Quiz(getString(R.string.question_profession),
                CheckBoxFragment.newInstance(GroupAnswers(
                    listOf (
                        Answer(1, getString(R.string.answer_lawyer)),
                        Answer(10, getString(R.string.answer_movie_star)),
                        Answer(7, getString(R.string.answer_teacher)),
                        Answer(4, getString(R.string.answer_author_novels)),
                        Answer(1, getString(R.string.answer_company_manager)),
                        Answer(7, getString(R.string.answer_landscaper)),
                        Answer(7, getString(R.string.answer_craftsman)),
                        Answer(10, getString(R.string.answer_butcher))
                    )
                ))
            )
        )

        quizzes.add(
            Quiz(getString(R.string.question_boggart),
                CheckBoxFragment.newInstance(GroupAnswers(
                    listOf (
                        Answer(1, getString(R.string.answer_snake)),
                        Answer(4, getString(R.string.answer_clown)),
                        Answer(7, getString(R.string.answer_spider)),
                        Answer(10, getString(R.string.answer_dementor))
                    )
                ))
            )
        )

        val currentQuestion = findViewById<TextView>(R.id.lastQuestionNumber)
        currentQuestion.text = quizzes.size.toString()
        updateNumberQuestion()

        showQuestion(quizzes[currentQuizIndex])
    }

    fun showQuestion(quiz : Quiz) {
        val textQuestion = findViewById<TextView>(R.id.questionContent)
        textQuestion.text = quiz.question
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.answerFragment, quiz.fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun handleAnswer(view: View) {
        val quiz = quizzes.get(currentQuizIndex)
        currentQuizIndex++

        if (currentQuizIndex >= quizzes.size) {
            val intent = Intent(this, AnswerActivity::class.java)
            startActivity(intent)
        }
        else {
            showQuestion(quizzes[currentQuizIndex])
            updateNumberQuestion()
        }
    }

    fun updateNumberQuestion() {
        val currentQuestion = findViewById<TextView>(R.id.currentQuestion)
        currentQuestion.text = (currentQuizIndex+1).toString()

    }
}

