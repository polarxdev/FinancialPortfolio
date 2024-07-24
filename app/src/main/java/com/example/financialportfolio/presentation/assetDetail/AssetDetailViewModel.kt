package com.example.financialportfolio.presentation.assetDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.interactor.AssetListInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetDetailViewModel
@Inject constructor(
    private val assetListIteractor: AssetListInteractor
) : ViewModel() {
    private val _asset = MutableLiveData<Asset>()
    val asset: LiveData<Asset> get() = _asset

    private val _toastMessage = MutableLiveData<String?>()
    val toastMessage: LiveData<String?> get() = _toastMessage

    fun loadAssetById(id: Int) {
        try {
            val loadedAsset = assetListIteractor.getAssetById(id)
            _asset.value = loadedAsset
        } catch (e: IllegalArgumentException) {
            _toastMessage.value = "Something went wrong"
        }
    }

    fun onToastShown() {
        _toastMessage.value = null
    }
}
