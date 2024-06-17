package ru.zhogin.app.api.models.tickets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TicketsDTO(
    @SerialName("tickets")
    val tickets: List<TicketDTO>
)
