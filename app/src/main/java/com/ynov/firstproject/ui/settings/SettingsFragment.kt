package com.ynov.firstproject.ui.settings

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Observer
import com.ynov.firstproject.R
import com.ynov.firstproject.data.UserPreferences
import com.ynov.firstproject.databinding.FragmentSettingsBinding
import com.ynov.firstproject.repository.UserPreferencesRepository

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = SettingsViewModel(UserPreferencesRepository(requireContext()))

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        val nameObserver = Observer<UserPreferences> { userPreference ->
            if (userPreference.name != "null") {
                binding.settingsInputName.setText(userPreference.name)
            }
        }

        viewModel.userPreference.observe(viewLifecycleOwner, nameObserver)

        binding.saveButton.setOnClickListener { saveSettings() }

        return binding.root
    }

    private fun saveSettings() {
        val textInput = binding.settingsInputName.text
        if (textInput.isNotEmpty() && textInput.isNotBlank()) {
            viewModel.updateName(textInput.toString())
            Toast.makeText(context, R.string.text_settings_saved, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, R.string.text_settings_unset, Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}