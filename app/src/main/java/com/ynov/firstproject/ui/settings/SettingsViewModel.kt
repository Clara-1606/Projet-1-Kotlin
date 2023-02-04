package com.ynov.firstproject.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.ynov.firstproject.data.UserPreferences
import com.ynov.firstproject.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
    ) : ViewModel() {

    val userPreference: LiveData<UserPreferences> = liveData {
        val data = userPreferencesRepository.userPreferencesFlow.first()
        emit(data)
    }

    fun updateName(name: String) {
        viewModelScope.launch {
            userPreferencesRepository.updateUserName(name)
        }
    }
}