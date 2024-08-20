package com.example.financialportfolio.data.database.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.AssetMeta
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Converters {
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String {
        return date.format(dateFormatter)
    }

    @TypeConverter
    fun toLocalDate(dateString: String): LocalDate {
        return LocalDate.parse(dateString, dateFormatter)
    }

    @TypeConverters
    fun fromAssetMeta(assetMeta: AssetMeta): String {
        return "${assetMeta.country}, ${assetMeta.sector}"
    }

    @TypeConverters
    fun toAssetMeta(data: String): AssetMeta {
        val parts = data.split(",")
        return AssetMeta(parts[0], parts[1])
    }

    @TypeConverters
    fun fromAsset(asset: Asset): String {
        return "${asset.id}, ${asset.name}, ${fromAssetMeta(asset.meta)}"
    }

    @TypeConverters
    fun toAsset(data: String): Asset {
        val parts = data.split(",")
        val assetMeta = AssetMeta(parts[2], parts[3])
        return Asset(parts[0].toInt(), parts[1], assetMeta)
    }
}
