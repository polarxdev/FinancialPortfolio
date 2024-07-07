package com.example.financialportfolio.data

import com.example.financialportfolio.domain.entity.AssetMeta
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.Stock
import com.example.financialportfolio.domain.entity.Bond
import java.time.LocalDate
import java.util.Date

object defaultAssetsList {
    private val assetsList = listOf(
        Cash(
            id = 1,
            name = "Cash in USD",
            amount = 123.0,
            meta = AssetMeta(country = "USA", sector = "Finances"),
            currency = "USD",
        ),
        Cash(
            id = 2,
            name = "Cash in EUR",
            amount = 456.0,
            meta = AssetMeta(country = "Germany", sector = "Finances"),
            currency = "EUR"
        ),
        Stock(
            id = 3,
            name = "Apple Stock",
            amount = 50.0,
            meta = AssetMeta(country = "USA", sector = "Technology"),
            ticker = "AAPL"
        ),
        Stock(
            id = 4,
            name = "Google Stock",
            amount = 30.0,
            meta = AssetMeta(country = "USA", sector = "Technology"),
            ticker = "GOOGL"
        ),
        Stock(
            id = 5,
            name = "Amazon Stock",
            amount = 20.0,
            meta = AssetMeta(country = "USA", sector = "E-Commerce"),
            ticker = "AMZN"
        ),
        Bond(
            id = 6,
            name = "US Treasury Bond",
            amount = 100.0,
            meta = AssetMeta(country = "USA", sector = "Government"),
            maturityDate = LocalDate.of(2024, 12, 2)
        ),
        Bond(
            id = 7,
            name = "Corporate Bond",
            amount = 200.0,
            meta = AssetMeta("USA", "Corporate"),
            maturityDate = LocalDate.of(2024, 12, 2)
        ),
        Cash(
            id = 8,
            name = "Cash in GBP",
            amount = 300.0,
            meta = AssetMeta("UK", "Finances"),
            currency = "GBP"
        ),
        Stock(
            id = 9,
            name = "Tesla Stock",
            amount = 40.0,
            meta = AssetMeta("USA", "Automotive"),
            ticker = "TSLA"
        ),
        Bond(
            id = 10,
            name = "Municipal Bond",
            amount = 150.0,
            meta = AssetMeta("USA", "Municipal"),
            maturityDate = LocalDate.of(2024, 12, 2)
        )
    )

    fun getDefaultAssetsList() = assetsList
}
