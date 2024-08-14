package com.example.financialportfolio.domain.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettingsList(): ArrayList<String>
    fun readCurrencyFromPreferences(context: Context): Flow<String>
    fun saveCurrencyToPreferences(currency: String, context: Context)
}
