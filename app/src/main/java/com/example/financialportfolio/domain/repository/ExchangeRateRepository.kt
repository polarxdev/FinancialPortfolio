package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.data.exchangerate.ExchangeRate

interface ExchangeRateRepository {
    suspend fun getExchangeRate(base: String): ExchangeRate
}
