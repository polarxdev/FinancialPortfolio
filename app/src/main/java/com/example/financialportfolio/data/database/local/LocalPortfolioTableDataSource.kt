package com.example.financialportfolio.data.database.local

import com.example.financialportfolio.data.database.PortfolioTableDataSource
import com.example.financialportfolio.data.database.dao.PortfolioDao
import com.example.financialportfolio.data.database.entity.PortfolioTable
import com.example.financialportfolio.domain.entity.PortfolioAsset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalPortfolioTableDataSource @Inject constructor(
    private val dao: PortfolioDao
) : PortfolioTableDataSource {
    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return withContext(Dispatchers.IO) {
            dao.getAllAssets()
        }
    }

    override suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        return withContext(Dispatchers.IO) {
            dao.insertAsset(asset)
        }
    }

    override suspend fun deletePortfolioAsset(id: Int) {
        return withContext(Dispatchers.IO) {
            dao.deleteAsset(id)
        }
    }
}
