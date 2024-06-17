package ru.zhogin.app.api.models.tickets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PriceXDTO(
    @SerialName("value")
    val value: Int
)
