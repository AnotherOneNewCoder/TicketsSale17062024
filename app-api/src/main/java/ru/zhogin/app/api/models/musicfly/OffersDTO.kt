package ru.zhogin.app.api.models.musicfly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OffersDTO(
    @SerialName("offers")
    val offers: List<OfferDTO>
)