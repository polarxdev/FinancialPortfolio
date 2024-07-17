package com.example.financialportfolio.domain.entity

import java.time.LocalDate

data class PortfolioAsset(
    val id: Int,
    val asset: Asset,
    val purchaseDate: LocalDate,
    val purchasePrice: Double,
    val currentPrice: Double
)