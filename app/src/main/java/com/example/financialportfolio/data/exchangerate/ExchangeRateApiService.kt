package com.example.financialportfolio.data.exchangerate

import com.example.financialportfolio.domain.entity.ExchangeRate
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRateApiService {
    @GET("{base}?parammode=2")
    suspend fun getExchangeRate(@Path("base") base: String): ExchangeRate
}
