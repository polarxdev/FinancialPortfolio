package com.example.financialportfolio.data

import com.example.financialportfolio.data.exchangerate.ExchangeRate
import com.example.financialportfolio.data.exchangerate.ExchangeRateApiService
import com.example.financialportfolio.domain.repository.ExchangeRateRepository
import javax.inject.Inject

class ExchangeRateRepositoryImpl @Inject constructor(
    private val exchangeRateApiService: ExchangeRateApiService
) : ExchangeRateRepository {
    override suspend fun getExchangeRate(base: String): ExchangeRate {
        return exchangeRateApiService.getExchangeRate(base)
    }
}
