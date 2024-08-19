package com.example.financialportfolio.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.financialportfolio.domain.interactor.SettingsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    private val _currencyFlow = MutableStateFlow("BYN")
    val currencyLiveData: LiveData<String> get() = _currencyFlow.asLiveData()

    private val _settingsList = MutableLiveData<List<String>>()
    val settingsList: LiveData<List<String>> get() = _settingsList

    fun getSettingsList() {
        viewModelScope.launch {
            val list = settingsInteractor.getSettingsList()
            _settingsList.postValue(list)
        }
    }

    fun readCurrency() {
        viewModelScope.launch {
            settingsInteractor.readCurrency().collect { currency ->
                _currencyFlow.value = currency
            }
        }
    }

    fun saveCurrency(currency: String) {
        viewModelScope.launch {
            settingsInteractor.saveCurrency(currency)
        }
    }
}
