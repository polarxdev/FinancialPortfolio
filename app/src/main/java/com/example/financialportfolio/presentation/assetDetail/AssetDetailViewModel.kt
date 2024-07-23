package com.example.financialportfolio.presentation.assetDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.usecase.GetAssetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetDetailViewModel
@Inject constructor(
    private val getAssetUseCase: GetAssetUseCase
) : ViewModel() {
    private val _asset = MutableLiveData<Asset>()
    val asset: LiveData<Asset> get() = _asset

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error
    fun loadAssetById(id: Int) {
        val loadedAsset = getAssetUseCase(id)
        _asset.value = loadedAsset
    }
}
