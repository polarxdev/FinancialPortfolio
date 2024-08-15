package com.example.financialportfolio.domain.interactor

import android.content.Context
import com.example.financialportfolio.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsInteractor @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    fun getSettingsList(): List<String> {
        return settingsRepository.getSettingsList()
    }

    fun readCurrencyFromPreferences(): Flow<String> {
        return settingsRepository.readCurrencyFromPreferences()
    }

    fun saveCurrencyToPreferences(currency: String) {
        return settingsRepository.saveCurrencyToPreferences(currency)
    }
}
