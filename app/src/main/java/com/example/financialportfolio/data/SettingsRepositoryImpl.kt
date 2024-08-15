package com.example.financialportfolio.data

import android.content.Context
import com.example.financialportfolio.data.datasource.SettingsDataSource
import com.example.financialportfolio.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataSource: SettingsDataSource
) : SettingsRepository {
    override fun getSettingsList(): List<String> {
        return dataSource.getSettingsList()
    }

    override fun readCurrencyFromPreferences(): Flow<String> {
        return dataSource.readCurrencyFromPreferences()
    }

    override fun saveCurrencyToPreferences(currency: String) {
        return dataSource.saveCurrencyToPreferences(currency)
    }
}
