package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetsListRepository {
    fun getPortfolioAssets(): List<PortfolioAsset>
    fun addPortfolioAsset(asset: PortfolioAsset)
    fun deletePortfolioAsset(id: Int)
}
