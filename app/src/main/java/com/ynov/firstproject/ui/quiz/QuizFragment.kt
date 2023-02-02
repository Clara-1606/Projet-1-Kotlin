package com.ynov.firstproject.ui.quiz

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.ynov.firstproject.R
import com.ynov.firstproject.databinding.FragmentQuizBinding
import com.ynov.firstproject.quiz.model.answer.Answer
import com.ynov.firstproject.quiz.model.question.*

class QuizFragment : Fragment() {

    private var questions = ArrayList<Question>()
    var currentQuizIndex : Int = 0
    var totalPoint : Int = 0
    var name : String? = ""

    private var _binding: FragmentQuizBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quizViewModel =
            ViewModelProvider(this).get(QuizViewModel::class.java)

        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Bind buttons
        binding.buttonValidate.setOnClickListener { handleAnswer() }
        binding.buttonBack.setOnClickListener { handlePreviousButton() }

        // Get name from bundle
        name = arguments?.getString("NAME").toString()
        createQuiz()

        return root
    }

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
            ToggleQuestion(getString(R.string.question_hermione),
                listOf (
                    Answer(10, getString(R.string.answer_no)),
                    Answer(5, getString(R.string.answer_yes)),
                ),
                R.drawable.hermione)
        )

        questions.add(
            ImageQuestion(getString(R.string.question_creature),
                mapOf(
                    Pair(R.drawable.hipogriffe, Answer(4, getString(R.string.answer_hippogriffe))),
                    Pair(R.drawable.phoenix, Answer(1, getString(R.string.question_phoenix))),
                    Pair(R.drawable.niffleur, Answer(7, getString(R.string.question_niffleur))),
                    Pair(R.drawable.basilic, Answer(10, getString(R.string.question_basilic)))
                )
            )
        )

        questions.add(
            RadioQuestion(getString(R.string.question_flaw),
                listOf (
                    Answer(7, getString(R.string.answer_selfish)),
                    Answer(4, getString(R.string.answer_fearful)),
                    Answer(10, getString(R.string.answer_arrogant)),
                    Answer(1, getString(R.string.answer_unstable))
                )
            )
        )

        questions.add(
            AutoCompleteQuestion(getString(R.string.question_wizard),
                listOf (
                    Answer(0, getString(R.string.answer_dumbledore)),
                    Answer(0, getString(R.string.answer_mc_gonagall)),
                    Answer(0, getString(R.string.answer_hadrig)),
                    Answer(0, getString(R.string.answer_sirius_black)),
                    Answer(0, getString(R.string.answer_harry_potter)),
                    Answer(0, getString(R.string.answer_fred_weasley)),
                    Answer(0, getString(R.string.answer_george_weasley)),
                    Answer(0, getString(R.string.answer_ron_weasley)),
                    Answer(0, getString(R.string.answer_hermione_granger)),
                    Answer(0, getString(R.string.answer_neville)),
                    Answer(0, getString(R.string.answer_severus_rogue)),
                    Answer(0, getString(R.string.answer_tom_jedusor)),
                    Answer(0, getString(R.string.answer_voldemort)),
                    Answer(0, getString(R.string.answer_draco_malefoy)),
                    Answer(0, getString(R.string.answer_cadwallader)),
                    Answer(0, getString(R.string.answer_luna_lovegood)),
                    Answer(0, getString(R.string.answer_cho_chang)),
                    Answer(0, getString(R.string.answer_filius_flitwick)),
                    Answer(0, getString(R.string.answer_sibyl_trelawney))
                )
            )
        )

        questions.shuffle();

        val currentQuestion = binding.lastQuestionNumber
        currentQuestion.text = questions.size.toString()
        updateNumberQuestion()

        showQuestion(questions[currentQuizIndex])
    }

    private fun showQuestion(question : Question) {
        val textQuestion = binding.questionContent
        textQuestion.text = question.label
        val questionView = question.buildAnswersWidgets(requireContext())
        val constraintLayout =  binding.answerLayout

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

    fun handleAnswer() {
        // Handle click on next question
        if (currentQuizIndex == questions.size - 1) {
            // Go to result fragment
            var resultValue = 0
            questions.forEach { q -> resultValue += q.selectedAnswerValue }
            val bundle = bundleOf()
            bundle.putString("NAME", name)
            bundle.putInt("RESULT", resultValue)
            findNavController().navigate(R.id.action_nav_quiz_to_nav_result, bundle)
        }
        else {
            if (questions[currentQuizIndex].selectedAnswerValue == -1)
            {
                Toast.makeText(requireContext(), R.string.answer_mandatory, Toast.LENGTH_SHORT).show()
            }else {
                currentQuizIndex++
                showQuestion(questions[currentQuizIndex])
                updateNumberQuestion()
            }

        }
    }

    fun handlePreviousButton(){
        if (currentQuizIndex > 0)
        {
            currentQuizIndex--
            val previousQuestion = questions[currentQuizIndex]
            previousQuestion.resetQuestion()
            showQuestion(previousQuestion)
            updateNumberQuestion()
        }
        else {
            // Go back to personal infos fragment
            val bundle = bundleOf("NAME" to name)
            findNavController().navigate(R.id.action_nav_quiz_to_nav_gallery, bundle)
        }
    }

    private fun updateNumberQuestion() {
        val currentQuestion = binding.currentQuestion
        currentQuestion.text = (currentQuizIndex + 1).toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}