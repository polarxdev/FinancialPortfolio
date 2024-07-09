package com.example.financialportfolio.data

import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.repository.AssetListRepository

class AssetListRepositoryImpl(
    private val dataSource: AssetListDataSource
) : AssetListRepository {

    private var assets = listOf<Asset>()

    init {
        assets = getAssets()
    }

    override fun getAssets(): List<Asset> {
        return dataSource.getAssets()
    }
}
