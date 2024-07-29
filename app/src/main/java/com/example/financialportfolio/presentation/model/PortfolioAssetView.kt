package com.example.financialportfolio.presentation.model

data class PortfolioAssetView(
    val id: String,
    val assetId: String,
    val name: String,
    var currentPrice: String,
    var purchasePrice: String,
    val purchaseDate: String
)
