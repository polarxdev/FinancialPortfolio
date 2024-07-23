package com.example.financialportfolio.data

import com.example.financialportfolio.data.exchangerate.RetrofitInstance
import com.example.financialportfolio.domain.entity.ExchangeRate
import com.example.financialportfolio.domain.repository.ExchangeRateRepository
import javax.inject.Inject

class ExchangeRateRepositoryImpl @Inject constructor() : ExchangeRateRepository {
    override suspend fun getExchangeRate(base: String): ExchangeRate {
        return RetrofitInstance.api.getExchangeRate(base)
    }
}
