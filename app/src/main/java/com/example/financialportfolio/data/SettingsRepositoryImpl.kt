package com.example.financialportfolio.data

import android.content.Context
import com.example.financialportfolio.data.datasource.SettingsDataSource
import com.example.financialportfolio.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataSource: SettingsDataSource
) : SettingsRepository {
    override fun getSettingsList(): ArrayList<String> {
        return dataSource.getSettingsList()
    }

    override fun readCurrencyFromPreferences(context: Context): Flow<String> {
        return dataSource.readCurrencyFromPreferences(context)
    }

    override fun saveCurrencyToPreferences(currency: String, context: Context) {
        return dataSource.saveCurrencyToPreferences(currency, context)
    }
}
