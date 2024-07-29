package com.example.financialportfolio.domain.entity

import com.squareup.moshi.Json

data class ExchangeRate(
    @field:Json(name = "Cur_ID")
    val id: Int = 0,

    @field:Json(name = "Date")
    val date: String = "",

    @field:Json(name = "Cur_Abbreviation")
    val abbreviation: String = "",

    @field:Json(name = "Cur_Scale")
    val scale: Int = 0,

    @field:Json(name = "Cur_Name")
    val name: String = "",

    @field:Json(name = "Cur_OfficialRate")
    val rate: Double = 0.0
)
