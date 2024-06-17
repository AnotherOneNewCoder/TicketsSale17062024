package ru.zhogin.app.api.models.tickets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArrivalDTO(
    @SerialName("airport")
    val airport: String,
    @SerialName("date")
    val date: String,
    @SerialName("town")
    val town: String
)
