package com.example.financialportfolio.data

import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.repository.AssetListRepository
import javax.inject.Inject

class AssetListRepositoryImpl @Inject constructor(
    private val dataSource: AssetListDataSource
) : AssetListRepository {

    override fun getAssets(): List<Asset> {
        return dataSource.getAssets()
    }

    override fun getAsset(id: Int): Asset {
        return dataSource.getAsset(id)
    }
}
