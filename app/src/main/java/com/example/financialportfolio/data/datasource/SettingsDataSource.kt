package com.example.financialportfolio.data.datasource

import android.content.Context
import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {
    fun getSettingsList(): ArrayList<String>
    fun readCurrencyFromPreferences(context: Context): Flow<String>
    fun saveCurrencyToPreferences(currency: String, context: Context)
}
