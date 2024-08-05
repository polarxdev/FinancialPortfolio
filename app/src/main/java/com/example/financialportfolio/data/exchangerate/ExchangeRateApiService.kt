package com.example.financialportfolio.data.exchangerate

import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRateApiService {
    @GET("/exrates/rates/{base}?parammode=2")
    suspend fun getExchangeRate(@Path("base") base: String): ExchangeRate
}
