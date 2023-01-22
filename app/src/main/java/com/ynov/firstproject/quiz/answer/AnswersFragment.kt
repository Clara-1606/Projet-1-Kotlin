package com.ynov.firstproject.quiz.answer


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ynov.firstproject.R
import com.ynov.firstproject.quiz.model.answer.GroupAnswers
import java.io.Serializable


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val GROUP_ANSWER = "groupAnswer"


/**
 * A simple [Fragment] subclass.
 * Use the [AnswersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class AnswersFragment : Fragment() {
    private var param1: GroupAnswers? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializableCompat(GROUP_ANSWER, GroupAnswers::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @return A new instance of fragment AnswersFragment.
//         */
//        @JvmStatic fun newInstance(param1: GroupAnswers) =
//                AnswersFragment().apply {
//                    arguments = Bundle().apply {
//                        putSerializable(GROUP_ANSWER, param1)
//                    }
//                }
//    }

    fun <T : Serializable?> Bundle.getSerializableCompat(key: String, clazz: Class<T>): T {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) getSerializable(key, clazz)!! else (getSerializable(key) as T)
    }
}