package com.ynov.firstproject.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ynov.firstproject.data.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

class UserPreferencesRepository(val context: Context) {
    private object PreferencesKeys {
        val NAME = stringPreferencesKey("user_name")
        val HOUSE = intPreferencesKey("user_house")
    }

    val userPreferencesFlow: Flow<UserPreferences> = context.dataStore.data
        .map { preferences ->
            val name = preferences[PreferencesKeys.NAME]
            val house = preferences[PreferencesKeys.HOUSE]
            UserPreferences(name.toString(), house)
        }

    suspend fun updateUserName(name: String){
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.NAME] = name
        }
    }
}