package com.ynov.firstproject.ui.personalinfos

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ynov.firstproject.data.UserPreferences
import com.ynov.firstproject.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.first

class PersonnalInfosViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    // Name
    val userName: LiveData<String?> = liveData {
        val data = userPreferencesRepository.userPreferencesFlow.first().name
        emit(data)
    }

    // House
    val userHouse: LiveData<Int?> = liveData {
        val data = userPreferencesRepository.userPreferencesFlow.first().house
        emit(data)
    }
}