package com.example.financialportfolio.data

import com.example.financialportfolio.data.database.PortfolioTableDataSource
import com.example.financialportfolio.data.database.entity.PortfolioTable
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import javax.inject.Inject

class PortfolioAssetListRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioTableDataSource
) : PortfolioAssetsListRepository {
    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return dataSource.getPortfolioAssets()
    }

    override suspend fun addPortfolioAsset(asset: PortfolioTable) {
        dataSource.addPortfolioAsset(asset)
    }

    override suspend fun deletePortfolioAsset(id: Int) {
        dataSource.deletePortfolioAsset(id)
    }
}
