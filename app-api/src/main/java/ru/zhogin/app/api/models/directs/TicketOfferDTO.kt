package ru.zhogin.app.api.models.directs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.zhogin.app.api.models.musicfly.PriceDTO

@Serializable
data class TicketOfferDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("price")
    val price: PriceDTO,
    @SerialName("time_range")
    val timeRange: List<String>,
    @SerialName("title")
    val title: String
)
