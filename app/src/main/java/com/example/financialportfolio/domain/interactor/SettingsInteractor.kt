package com.example.financialportfolio.domain.interactor

import com.example.financialportfolio.domain.entity.Constants
import com.example.financialportfolio.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsInteractor @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    fun getSettingsList(): List<String> {
        return Constants.CURRENCY_LIST
    }

    suspend fun readCurrency(): Flow<String> {
        return settingsRepository.readCurrency()
    }

    fun saveCurrency(currency: String) {
        return settingsRepository.saveCurrency(currency)
    }
}
