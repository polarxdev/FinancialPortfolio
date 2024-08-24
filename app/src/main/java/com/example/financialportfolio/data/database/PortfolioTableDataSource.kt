package com.example.financialportfolio.data.database

import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioTableDataSource {
    suspend fun getPortfolioAssets(): List<PortfolioAsset>
    suspend fun addPortfolioAsset(asset: PortfolioAsset)
    suspend fun deletePortfolioAsset(id: Int)
}
