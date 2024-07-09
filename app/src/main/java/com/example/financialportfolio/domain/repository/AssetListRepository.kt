package com.example.financialportfolio.domain.repository

import com.example.financialportfolio.domain.entity.Asset

interface AssetListRepository {
    fun getAssets(): List<Asset>
}
