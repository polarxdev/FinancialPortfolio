package com.example.financialportfolio.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financialportfolio.domain.entity.Asset
import java.time.LocalDate

@Entity(tableName = "portfolio_table")
data class PortfolioTable(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,
    @Embedded
    val asset: Asset,
    @ColumnInfo("purchase_date")
    val purchaseDate: LocalDate,
    @ColumnInfo("purchase_price")
    val purchasePrice: Double,
    @ColumnInfo("current_price")
    val currentPrice: Double
)
