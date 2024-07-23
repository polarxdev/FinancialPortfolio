package com.example.financialportfolio.data

import com.example.financialportfolio.data.datasource.PortfolioAssetListDataSource
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import javax.inject.Inject

class PortfolioAssetListRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioAssetListDataSource
) : PortfolioAssetsListRepository {
    override fun getPortfolioAssets(): List<PortfolioAsset> {
        return dataSource.getPortfolioAssets()
    }

    override fun addPortfolioAsset(asset: PortfolioAsset) {
        dataSource.addPortfolioAsset(asset)
    }

    override fun deletePortfolioAsset(asset: PortfolioAsset) {
        dataSource.deletePortfolioAsset(asset)
    }
}
