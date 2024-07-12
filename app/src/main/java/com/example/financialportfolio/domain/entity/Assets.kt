package com.example.financialportfolio.domain.entity

import java.time.LocalDate

data class AssetMeta(
    val country: String,
    val sector: String
)

open class Asset(
    open val id: Int,
    open val name: String,
    open val meta: AssetMeta
)

data class Cash(
    override val id: Int,
    override val name: String,
    override val meta: AssetMeta,
    val currency: String
) : Asset(id, name, meta)

data class Stock(
    override val id: Int,
    override val name: String,
    override val meta: AssetMeta,
    val ticker: String
) : Asset(id, name, meta)

data class Bond(
    override val id: Int,
    override val name: String,
    override val meta: AssetMeta,
    val maturityDate: LocalDate
) : Asset(id, name, meta)
