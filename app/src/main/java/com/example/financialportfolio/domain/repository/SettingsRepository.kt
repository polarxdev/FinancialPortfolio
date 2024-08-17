package com.example.financialportfolio.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun readCurrency(): Flow<String>
    fun saveCurrency(currency: String)
}
