package ru.zhogin.app.api.models.tickets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LuggageDTO(
    @SerialName("has_luggage")
    val hasLuggage: Boolean,
    @SerialName("price")
    val price: PriceXDTO? = null,
)