package com.example.financialportfolio.data.database

import com.example.financialportfolio.data.database.entity.PortfolioTable
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PortfolioTableImpl @Inject constructor(
    private val dataSource: PortfolioTableDataSource
) : PortfolioAssetsListRepository {
    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioAssets()
        }
    }

    override suspend fun addPortfolioAsset(asset: PortfolioTable) {
        return withContext(Dispatchers.IO) {
            dataSource.addPortfolioAsset(asset)
        }
    }

    override suspend fun deletePortfolioAsset(id: Int) {
        return withContext(Dispatchers.IO) {
            dataSource.deletePortfolioAsset(id)
        }
    }
}
