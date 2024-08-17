package com.example.financialportfolio.data.datasource

import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {
    suspend fun readCurrency(): Flow<String>
    fun saveCurrency(currency: String)
}
