package com.example.financialportfolio.domain.entity

import com.google.gson.annotations.SerializedName

data class ExchangeRate(
    @SerializedName("Cur_ID") val id: Int = 0,
    @SerializedName("Date") val date: String = "",
    @SerializedName("Cur_Abbreviation") val abbreviation: String = "",
    @SerializedName("Cur_Scale") val scale: Int = 0,
    @SerializedName("Cur_Name") val name: String = "",
    @SerializedName("Cur_OfficialRate") val rate: Double = 0.0
)
