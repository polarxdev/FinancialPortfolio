package com.example.financialportfolio.data.datasource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.financialportfolio.data.datasource.SettingsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalSettingsDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SettingsDataSource {
    private val currency: Preferences.Key<String> = stringPreferencesKey("currency")

    override suspend fun readCurrency(): Flow<String> {
        return withContext(Dispatchers.IO) {
            dataStore.data
                .map { preferences ->
                    preferences[currency] ?: "BYN"
                }
        }
    }

    override fun saveCurrency(currency: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.edit { preferences ->
                preferences[this@LocalSettingsDataSource.currency] = currency
            }
        }
    }
}
