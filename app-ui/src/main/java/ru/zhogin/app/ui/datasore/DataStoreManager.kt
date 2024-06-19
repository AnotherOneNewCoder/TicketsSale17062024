package ru.zhogin.app.ui.datasore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import ru.zhogin.app.ui.datasore.data.SettingsData

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("data_store")
class DataStoreManager(val context: Context) {

    suspend fun saveSettings(settingsData: SettingsData) {
        context.dataStore.edit { pref ->
            pref[stringPreferencesKey("departure_from")] = settingsData.departureFrom
        }
    }
    fun getSettings() = context.dataStore.data.map { pref ->
        return@map SettingsData(
            pref[stringPreferencesKey("departure_from")] ?: ""
        )
    }
}