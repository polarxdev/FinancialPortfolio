package com.example.financialportfolio.domain.interactor

import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.repository.AssetListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetListInteractor @Inject constructor(
    private val assetListRepository: AssetListRepository
) {
    fun getAssetList(): List<Asset> {
        return assetListRepository.getAssets()
    }

    fun getAsset(id: Int): Asset {
        return assetListRepository.getAsset(id)
    }
}
