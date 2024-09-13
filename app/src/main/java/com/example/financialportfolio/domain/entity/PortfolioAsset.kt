package com.example.financialportfolio.domain.entity

import java.time.LocalDate

data class PortfolioAsset(
    var id: Int,
    val asset: Asset,
    val purchaseDate: LocalDate,
    val purchasePrice: Double,
    val currentPrice: Double
)
