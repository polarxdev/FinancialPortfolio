package com.example.financialportfolio.presentation.settings

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financialportfolio.domain.interactor.SettingsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    private val _selectedCurrency = MutableLiveData<String>()
    val selectedCurrency: LiveData<String> get() = _selectedCurrency

    private val _savedCurrency = MutableLiveData<String>()
    val savedCurrency: LiveData<String> get() = _savedCurrency

    private val _settingsList = MutableLiveData<List<String>>()
    val settingsList: LiveData<List<String>> get() = _settingsList

    fun selectCurrency(currency: String) {
        _selectedCurrency.value = currency
    }

    fun getSettingsList() {
        viewModelScope.launch {
            val list = settingsInteractor.getSettingsList()
            _settingsList.postValue(list)
        }
    }

    fun readCurrencyFromPreferences() {
        viewModelScope.launch {
            settingsInteractor.readCurrencyFromPreferences().collect { value ->
                _savedCurrency.postValue(value)
            }
        }
    }

    fun saveCurrencyToPreferences(currency: String) {
        viewModelScope.launch {
            settingsInteractor.saveCurrencyToPreferences(currency)
        }
    }
}
