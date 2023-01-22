package com.ynov.firstproject.quiz.answer

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.ynov.firstproject.quiz.model.answer.GroupAnswers


private const val GROUP_ANSWER = "groupAnswer"

/**
 * A simple [Fragment] subclass.
 * Use the [SpinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpinnerFragment : Fragment() {
        companion object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @return A new instance of fragment AnswersFragment.
             */
            @JvmStatic fun newInstance(param1: GroupAnswers) =
                Fragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(GROUP_ANSWER, param1)
                    }
                }
        }

    /**
     * Called immediately after [.onCreateView]
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     * @param view The View returned by [.onCreateView].
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val spinner: Spinner = view.findViewById(R.id.spinner)
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        val adapter = ArrayAdapter.createFromResource(
//            this,
//            arguments?.getString(GROUP_ANSWER), android.R.layout.simple_spinner_item
//        )
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        // Apply the adapter to the spinner
//        spinner.adapter = adapter
//    }
}