package com.example.financialportfolio.data

import kotlinx.coroutines.flow.Flow
import com.example.financialportfolio.data.datasource.SettingsDataSource
import com.example.financialportfolio.domain.repository.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataSource: SettingsDataSource
) : SettingsRepository {
    override suspend fun readCurrency(): Flow<String> {
        return dataSource.readCurrency()
    }

    override fun saveCurrency(currency: String) {
        return dataSource.saveCurrency(currency)
    }
}
