package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.data.database.entity.PortfolioTable
import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetsListRepository {
    suspend fun getPortfolioAssets(): List<PortfolioAsset>
    suspend fun addPortfolioAsset(asset: PortfolioTable)
    suspend fun deletePortfolioAsset(id: Int)
}
