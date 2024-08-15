package com.example.financialportfolio.data.datasource.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.financialportfolio.data.datasource.SettingsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalSettingsDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val CURRENCY: Preferences.Key<String>
) : SettingsDataSource {
    private val settingsList = listOf("BYN", "CNY", "RUB", "EUR", "USD")
    override fun getSettingsList() = settingsList

    override fun readCurrencyFromPreferences(): Flow<String> {
        return dataStore.data
            .map { preferences ->
                preferences[CURRENCY] ?: "BYN"
            }
    }

    override fun saveCurrencyToPreferences(currency: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.edit { preferences ->
                preferences[CURRENCY] = currency
            }
        }
    }
}
