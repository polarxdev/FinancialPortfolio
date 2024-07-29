package com.example.financialportfolio.domain.mapper

import android.icu.text.DecimalFormat
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.interactor.ExchangeRateInteractor
import com.example.financialportfolio.presentation.model.PortfolioAssetView

suspend fun PortfolioAsset.toView(
    exchangeRateInteractor: ExchangeRateInteractor,
    targetCurrency: String
): PortfolioAssetView {
    val convertedCurrentPrice =
        exchangeRateInteractor.convertCurrency(this.currentPrice, targetCurrency)
    val convertedPurchasePrice =
        exchangeRateInteractor.convertCurrency(this.purchasePrice, targetCurrency)
    return PortfolioAssetView(
        id = this.id.toString(),
        assetId = this.asset.id.toString(),
        name = this.asset.name,
        currentPrice = DecimalFormat("#.##").format(convertedCurrentPrice) + " $targetCurrency",
        purchasePrice = DecimalFormat("#.##").format(convertedPurchasePrice) + " $targetCurrency",
        purchaseDate = this.purchaseDate.toString()
    )
}
