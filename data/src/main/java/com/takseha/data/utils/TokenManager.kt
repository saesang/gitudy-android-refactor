package com.takseha.data.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val KEY_ACCESS_TOKEN = stringPreferencesKey("access_token")
        private val KEY_REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    }

    suspend fun getAccessToken(): String {
        return dataStore.data.map { it[KEY_ACCESS_TOKEN] ?: "" }.first()
    }

    suspend fun getRefreshToken(): String {
        return dataStore.data.map { it[KEY_REFRESH_TOKEN] ?: "" }.first()
    }

    suspend fun saveAccessToken(accessToken: String?) {
        dataStore.edit { prefs -> prefs[KEY_ACCESS_TOKEN] = accessToken ?: "" }
    }

    suspend fun saveRefreshToken(refreshToken: String?) {
        dataStore.edit { prefs -> prefs[KEY_REFRESH_TOKEN] = refreshToken ?: "" }
    }
}
