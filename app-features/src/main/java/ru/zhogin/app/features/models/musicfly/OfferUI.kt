package ru.zhogin.app.features.models.musicfly

import ru.zhogin.app.features.models.PriceUI

data class OfferUI(
    val id: Int,
    val price: PriceUI,
    val title: String,
    val town: String
)
