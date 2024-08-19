package com.example.financialportfolio.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.financialportfolio.data.AssetListRepositoryImpl
import com.example.financialportfolio.data.ExchangeRateRepositoryImpl
import com.example.financialportfolio.data.PortfolioAssetListRepositoryImpl
import com.example.financialportfolio.data.SettingsRepositoryImpl
import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.data.datasource.PortfolioAssetListDataSource
import com.example.financialportfolio.data.datasource.SettingsDataSource
import com.example.financialportfolio.data.datasource.local.LocalAssetListDataSource
import com.example.financialportfolio.data.datasource.local.LocalPortfolioListDataSource
import com.example.financialportfolio.data.datasource.local.LocalSettingsDataSource
import com.example.financialportfolio.data.exchangerate.ExchangeRateApiService
import com.example.financialportfolio.domain.repository.AssetListRepository
import com.example.financialportfolio.domain.repository.ExchangeRateRepository
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import com.example.financialportfolio.domain.repository.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindAssetListRepository(
        repositoryImpl: AssetListRepositoryImpl
    ): AssetListRepository

    @Binds
    @Singleton
    fun bindAssetListDataSource(
        dataSourceImpl: LocalAssetListDataSource
    ): AssetListDataSource

    @Binds
    @Singleton
    fun bindPortfolioAssetListRepository(
        repositoryImpl: PortfolioAssetListRepositoryImpl
    ): PortfolioAssetsListRepository

    @Binds
    @Singleton
    fun bindPortfolioAssetListDataSource(
        dataSourceImpl: LocalPortfolioListDataSource
    ): PortfolioAssetListDataSource

    @Binds
    @Singleton
    fun bindSettingsRepository(
        repositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository

    @Binds
    @Singleton
    fun bindSettingsDataSource(
        dataSourceImpl: LocalSettingsDataSource
    ): SettingsDataSource

    @Binds
    @Singleton
    fun bindExchangeRateRepository(
        repositoryImpl: ExchangeRateRepositoryImpl
    ): ExchangeRateRepository

    companion object {
        @Provides
        @Singleton
        fun provideExchangeRateApiService(
            retrofit: Retrofit
        ): ExchangeRateApiService {
            return retrofit.create(ExchangeRateApiService::class.java)
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        }

        @Provides
        @Singleton
        fun provideConverterFactory(): Converter.Factory {
            return Json.asConverterFactory("application/json; charset=UTF-8".toMediaType())
        }

        @Provides
        @Singleton
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory
        ): Retrofit {
            val BASE_URL = "https://api.nbrb.by"

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .build()
        }

        private val Context.dataStore by preferencesDataStore(name = "settings")

        @Provides
        @Singleton
        fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
            return context.dataStore
        }
    }
}
