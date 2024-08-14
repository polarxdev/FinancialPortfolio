package com.example.financialportfolio.data.datasource.defaults

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

object DefaultSettings {
    private val Context.dataStore by preferencesDataStore(name = "settings")
    var CURRENCY = stringPreferencesKey("currency")
    private val settingsList = arrayListOf("BYN", "CNY", "RUB", "EUR", "USD")

    fun getSettingsList() = settingsList

    fun readCurrencyFromPreferences(context: Context): Flow<String> {
        return context.dataStore.data
            .map { preferences ->
                preferences[CURRENCY] ?: "BYN"
            }
    }

    fun saveCurrencyToPreferences(currency: String, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            context.dataStore.edit { preferences ->
                preferences[CURRENCY] = currency
            }
        }
    }
}
