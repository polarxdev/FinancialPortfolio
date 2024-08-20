package com.example.financialportfolio.data.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.financialportfolio.data.database.converters.Converters
import com.example.financialportfolio.data.database.dao.PortfolioDao
import com.example.financialportfolio.data.database.entity.PortfolioTable

@Database(entities = [PortfolioTable::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): PortfolioDao
}
