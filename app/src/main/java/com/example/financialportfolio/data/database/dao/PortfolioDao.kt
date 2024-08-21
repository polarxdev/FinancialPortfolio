package com.example.financialportfolio.data.database.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.financialportfolio.data.database.entity.PortfolioTable
import com.example.financialportfolio.domain.entity.PortfolioAsset

@Dao
interface PortfolioDao {
    @Insert
    fun insertAssetTable(asset: PortfolioTable)

    @Query("DELETE FROM portfolio_table WHERE id = :id")
    fun deleteAsset(id: Int)

    @Query("SELECT * FROM portfolio_table")
    fun getAllAssetsTables(): List<PortfolioTable>

    fun getAllAssets(): List<PortfolioAsset> {
        return getAllAssetsTables().map { portfolioTable ->
            PortfolioAsset(
                id = portfolioTable.id,
                asset = portfolioTable.asset,
                purchaseDate = portfolioTable.purchaseDate,
                purchasePrice = portfolioTable.purchasePrice,
                currentPrice = portfolioTable.currentPrice
            )
        }
    }

    fun insertAsset(asset: PortfolioAsset) {
        insertAssetTable(PortfolioTable(
            id = asset.id,
            asset = asset.asset,
            purchaseDate = asset.purchaseDate,
            purchasePrice = asset.purchasePrice,
            currentPrice = asset.currentPrice
        ))
    }
}
