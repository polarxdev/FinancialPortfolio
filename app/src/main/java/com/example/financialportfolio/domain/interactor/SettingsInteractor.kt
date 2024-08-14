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
    fun getSettingsList(): ArrayList<String> {
        return settingsRepository.getSettingsList()
    }

    fun readCurrencyFromPreferences(context: Context): Flow<String> {
        return settingsRepository.readCurrencyFromPreferences(context)
    }

    fun saveCurrencyToPreferences(currency: String, context: Context) {
        return settingsRepository.saveCurrencyToPreferences(currency, context)
    }
}
