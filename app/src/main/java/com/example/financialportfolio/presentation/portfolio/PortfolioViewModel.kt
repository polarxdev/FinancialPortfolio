package com.example.financialportfolio.presentation.portfolio

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
            val portfolioAssets =
                portfolioAssetListInteractor.getPortfolioAssetList().map { portfolioAsset ->
                    portfolioAsset.toView(
                        exchangeRateInteractor,
                        "USD"
                    )
                }
            _portfolioAssetList.postValue(portfolioAssets)
        }
    }

    fun deletePortfolioAsset(id: Int) {
        portfolioAssetListInteractor.deletePortfolioAsset(id)
        loadPortfolioAssets()
    }
}
