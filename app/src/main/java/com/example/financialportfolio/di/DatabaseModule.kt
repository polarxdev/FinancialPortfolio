package com.example.financialportfolio.di

import android.content.Context
import androidx.room.Room
import com.example.financialportfolio.data.PortfolioAssetListRepositoryImpl
import com.example.financialportfolio.data.database.PortfolioTableDataSource
import com.example.financialportfolio.data.database.dao.PortfolioDao
import com.example.financialportfolio.data.database.local.AppDatabase
import com.example.financialportfolio.data.database.local.LocalPortfolioTableDataSource
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {

    @Binds
    @Singleton
    fun bindPortfolioAssetListRepository(
        repositoryImpl: PortfolioAssetListRepositoryImpl
    ): PortfolioAssetsListRepository

    @Binds
    @Singleton
    fun bindPortfolioAssetListDataSource(
        dataSourceImpl: LocalPortfolioTableDataSource
    ): PortfolioTableDataSource

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "AppDatabase.db"
            ).build()
        }

        @Provides
        @Singleton
        fun providePortfolioDao(appDatabase: AppDatabase): PortfolioDao {
            return appDatabase.getDao()
        }
    }
}
