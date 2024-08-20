package com.example.financialportfolio.presentation.portfolio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financialportfolio.domain.interactor.ExchangeRateInteractor
import com.example.financialportfolio.domain.interactor.PortfolioAssetListInteractor
import com.example.financialportfolio.domain.mapper.toView
import com.example.financialportfolio.presentation.model.PortfolioAssetView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioAssetListInteractor: PortfolioAssetListInteractor,
    private val exchangeRateInteractor: ExchangeRateInteractor
) : ViewModel() {

    private val _portfolioAssetList = MutableLiveData<List<PortfolioAssetView>>()
    val portfolioAssetList: LiveData<List<PortfolioAssetView>> get() = _portfolioAssetList

    init {
        loadPortfolioAssets()
    }

    private fun loadPortfolioAssets() {
        viewModelScope.launch {
            try {
                val portfolioAssets =
                    portfolioAssetListInteractor.getPortfolioAssetList().map { portfolioAsset ->
                        portfolioAsset.toView(
                            exchangeRateInteractor,
                            "USD"
                        )
                    }
                _portfolioAssetList.postValue(portfolioAssets)
            } catch (e: Exception) {
                Log.e("PortfolioViewModel", "Error loading portfolio assets", e)
            }
        }
    }

    fun deletePortfolioAsset(id: Int) {
        viewModelScope.launch {
            try {
                portfolioAssetListInteractor.deletePortfolioAsset(id)
                loadPortfolioAssets()
            } catch (e: Exception) {
                Log.e("PortfolioViewModel", "Error deleting portfolio asset", e)
            }
        }
    }
}
