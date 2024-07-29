package com.example.financialportfolio.presentation.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.interactor.AssetListInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetListViewModel
@Inject constructor(
    private val assetListInteractor: AssetListInteractor
) : ViewModel() {

    private val _assetList = MutableLiveData<List<Asset>>()
    val assetList: LiveData<List<Asset>> get() = _assetList

    init {
        loadAssets()
    }

    private fun loadAssets() {
        _assetList.value = assetListInteractor.getAssetList()
    }
}
