package ru.zhogin.app.api.models.directs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TicketOffersDTO(
    @SerialName("tickets_offers")
    val ticketOffer: List<TicketOfferDTO>
)
