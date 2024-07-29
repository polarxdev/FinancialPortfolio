package com.example.financialportfolio.data.datasource.defaults

import com.example.financialportfolio.domain.entity.AssetMeta
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.PortfolioAsset
import java.time.LocalDate

object DefaultPortfolioAssetsList {
    private val portfolioAssetsList = mutableListOf<PortfolioAsset>(
        PortfolioAsset(
            id = 1,
            asset = Cash(
                id = 1,
                name = "Name",
                currency = "USD",
                meta = AssetMeta(country = "USA", sector = "Financial")
            ),
            currentPrice = 12.0,
            purchaseDate = LocalDate.of(2023, 12, 1),
            purchasePrice = 14.4
        )
    )

    fun getPortfolioAssetsList() = portfolioAssetsList

    fun addPortfolioAsset(asset: PortfolioAsset) {
        portfolioAssetsList.add(asset)
    }

    fun deletePortfolioAsset(id: Int) {
        val portfolioAssetToDelete = portfolioAssetsList.first { it.id == id }
        portfolioAssetsList.remove(portfolioAssetToDelete)
    }
}
