package com.ynov.firstproject.ui.personalinfos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ynov.firstproject.R
import com.ynov.firstproject.data.UserPreferences
import com.ynov.firstproject.databinding.FragmentPersonalInfosBinding
import com.ynov.firstproject.repository.UserPreferencesRepository
import com.ynov.firstproject.ui.settings.SettingsViewModel

class PersonalInfosFragment : Fragment() {

    private var _binding: FragmentPersonalInfosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val personnalInfosViewModel =
            PersonnalInfosViewModel(UserPreferencesRepository(requireContext()))

        _binding = FragmentPersonalInfosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val nameObserver = Observer<String?> { userName ->
            binding.inputName.setText(userName)
        }

        personnalInfosViewModel.userName.observe(viewLifecycleOwner, nameObserver)

        binding.startQuestionsButton.setOnClickListener {
            playQuiz()
        }

        return root
    }

    private fun playQuiz(){
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