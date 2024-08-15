package com.example.financialportfolio.domain.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettingsList(): List<String>
    fun readCurrencyFromPreferences(): Flow<String>
    fun saveCurrencyToPreferences(currency: String)
}
