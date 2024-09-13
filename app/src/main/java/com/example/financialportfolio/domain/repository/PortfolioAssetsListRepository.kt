package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetsListRepository {
    suspend fun getPortfolioAssets(): List<PortfolioAsset>
    suspend fun addPortfolioAsset(asset: PortfolioAsset)
    suspend fun deletePortfolioAsset(id: Int)
}
