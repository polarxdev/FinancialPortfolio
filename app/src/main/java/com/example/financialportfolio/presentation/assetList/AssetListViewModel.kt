package com.example.financialportfolio.presentation.assetList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.usecase.GetAssetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetListViewModel
@Inject constructor(
    private val getAssetListUseCase: GetAssetListUseCase
) : ViewModel() {

    private val _model = MutableLiveData<List<Asset>>()
    val model: LiveData<List<Asset>> get() = _model

    init {
        loadAssets()
    }

    private fun loadAssets() {
        _model.value = getAssetListUseCase.execute()
    }
}
