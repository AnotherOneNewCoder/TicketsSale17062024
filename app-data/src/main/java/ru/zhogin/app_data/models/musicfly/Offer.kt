package ru.zhogin.app_data.models.musicfly

import ru.zhogin.app_data.models.Price

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)
