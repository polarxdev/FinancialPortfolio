package com.example.financialportfolio.domain.interactor

import com.example.financialportfolio.data.exchangerate.ExchangeRate
import com.example.financialportfolio.domain.repository.ExchangeRateRepository
import javax.inject.Inject

class ExchangeRateInteractor @Inject constructor(
    private val exchangeRateRepository: ExchangeRateRepository
) {
    suspend fun getExchangeRate(base: String): ExchangeRate {
        return exchangeRateRepository.getExchangeRate(base)
    }

    suspend fun convertCurrency(amount: Double, toCurrency: String): Double {
        val exchangeRate = getExchangeRate(toCurrency)
        return amount / exchangeRate.rate * exchangeRate.scale
    }
}
