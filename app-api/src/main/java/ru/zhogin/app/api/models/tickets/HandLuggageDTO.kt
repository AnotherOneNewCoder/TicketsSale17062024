package ru.zhogin.app.api.models.tickets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HandLuggageDTO(
    @SerialName("has_hand_luggage")
    val hasHandLuggage: Boolean,
    @SerialName("size")
    val size: String? = null,
)
