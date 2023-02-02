package com.ynov.firstproject.ui.personalinfos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ynov.firstproject.R
import com.ynov.firstproject.databinding.FragmentGalleryBinding
import com.ynov.firstproject.quiz.QuizActivity

class PersonalInfosFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val personnalInfosViewModel =
            ViewModelProvider(this).get(PersonnalInfosViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.startQuestionsButton.setOnClickListener {
            playQuiz()
        }

        return root
    }

    fun playQuiz(){
        val textInput = binding.inputName
        if (textInput.text.isNotEmpty() && textInput.text.isNotBlank()) {
            val bundle = bundleOf()
            bundle.putString("NAME",textInput.text.toString())
            findNavController().navigate(R.id.action_nav_gallery_to_nav_quiz, bundle)
        }
        else {
            Toast.makeText(context, R.string.answer_mandatory, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}