package ru.zhogin.app.api.models.musicfly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("price")
    val price: PriceDTO,
    @SerialName("title")
    val title: String,
    @SerialName("town")
    val town: String
)
