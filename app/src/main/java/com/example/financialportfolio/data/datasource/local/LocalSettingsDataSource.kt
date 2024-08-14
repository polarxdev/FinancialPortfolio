package com.example.financialportfolio.data.datasource.local

import android.content.Context
import com.example.financialportfolio.data.datasource.SettingsDataSource
import com.example.financialportfolio.data.datasource.defaults.DefaultSettings
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalSettingsDataSource @Inject constructor() : SettingsDataSource {
    override fun getSettingsList(): ArrayList<String> {
        return DefaultSettings.getSettingsList()
    }

    override fun readCurrencyFromPreferences(context: Context): Flow<String> {
        return DefaultSettings.readCurrencyFromPreferences(context)
    }

    override fun saveCurrencyToPreferences(currency: String, context: Context) {
        DefaultSettings.saveCurrencyToPreferences(currency, context)
    }
}
