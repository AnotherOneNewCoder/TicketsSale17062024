package ru.zhogin.app.api.models.directs

import kotlinx.serialization.SerialName

data class TicketOffersDTO(
    @SerialName("tickets_offers")
    val ticketOffer: List<TicketOfferDTO>
)
