package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetsListRepository {
    fun getPortfolioAssets(): List<PortfolioAsset>
    fun getPortfolioAssetById(id: Int): PortfolioAsset
}