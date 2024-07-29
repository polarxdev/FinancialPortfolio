package com.example.financialportfolio.data

import com.example.financialportfolio.data.exchangerate.RetrofitInstance
import com.example.financialportfolio.domain.entity.ExchangeRate
import com.example.financialportfolio.domain.repository.ExchangeRateRepository
import javax.inject.Inject

class ExchangeRateRepositoryImpl @Inject constructor(
    private val retrofitInstance: RetrofitInstance
) : ExchangeRateRepository {
    override suspend fun getExchangeRate(base: String): ExchangeRate {
        return retrofitInstance.api.getExchangeRate(base)
    }
}
