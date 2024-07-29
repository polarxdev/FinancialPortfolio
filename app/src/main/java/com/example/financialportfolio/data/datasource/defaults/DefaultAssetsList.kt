package com.example.financialportfolio.data.datasource.defaults

import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.AssetMeta
import com.example.financialportfolio.domain.entity.Bond
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.Stock
import java.time.LocalDate

object DefaultAssetsList {
    private val assetsList = listOf(
        Cash(
            id = 1,
            name = "Cash in USD",
            meta = AssetMeta(country = "USA", sector = "Finances"),
            currency = "USD"
        ),
        Cash(
            id = 2,
            name = "Cash in EUR",
            meta = AssetMeta(country = "Germany", sector = "Finances"),
            currency = "EUR"
        ),
        Stock(
            id = 3,
            name = "Apple Stock",
            meta = AssetMeta(country = "USA", sector = "Technology"),
            ticker = "AAPL"
        ),
        Stock(
            id = 4,
            name = "Google Stock",
            meta = AssetMeta(country = "USA", sector = "Technology"),
            ticker = "GOOGL"
        ),
        Stock(
            id = 5,
            name = "Amazon Stock",
            meta = AssetMeta(country = "USA", sector = "E-Commerce"),
            ticker = "AMZN"
        ),
        Bond(
            id = 6,
            name = "US Treasury Bond",
            meta = AssetMeta(country = "USA", sector = "Government"),
            maturityDate = LocalDate.of(2024, 12, 2)
        ),
        Bond(
            id = 7,
            name = "Corporate Bond",
            meta = AssetMeta("USA", "Corporate"),
            maturityDate = LocalDate.of(2024, 12, 2)
        ),
        Cash(
            id = 8,
            name = "Cash in GBP",
            meta = AssetMeta("UK", "Finances"),
            currency = "GBP"
        ),
        Stock(
            id = 9,
            name = "Tesla Stock",
            meta = AssetMeta("USA", "Automotive"),
            ticker = "TSLA"
        ),
        Bond(
            id = 10,
            name = "Municipal Bond",
            meta = AssetMeta("USA", "Municipal"),
            maturityDate = LocalDate.of(2024, 12, 2)
        )
    )

    fun getAssetsList() = assetsList

    fun getAssetById(id: Int): Asset {
        return assetsList.find { it.id == id } ?: throw IllegalArgumentException("No such asset")
    }
}
