package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.domain.entity.ExchangeRate

interface ExchangeRateRepository {
    suspend fun getExchangeRate(base: String): ExchangeRate
}
