package com.ynov.firstproject.quiz.answer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.model.answer.GroupAnswers

private const val GROUP_ANSWER = "groupAnswer"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckBoxFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckBoxFragment : AnswersFragment() {
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment AnswersFragment.
         */
        @JvmStatic fun newInstance(param1: GroupAnswers) =
            AnswersFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(GROUP_ANSWER, param1)
                }
            }
    }

}