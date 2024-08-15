package com.example.financialportfolio.data.datasource

import android.content.Context
import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {
    fun getSettingsList(): List<String>
    fun readCurrencyFromPreferences(): Flow<String>
    fun saveCurrencyToPreferences(currency: String)
}
