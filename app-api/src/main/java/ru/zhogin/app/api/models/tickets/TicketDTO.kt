package ru.zhogin.app.api.models.tickets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TicketDTO(
    @SerialName("arrival")
    val arrival: ArrivalDTO,
    @SerialName("badge")
    val badge: String? = null,
    @SerialName("company")
    val company: String,
    @SerialName("departure")
    val departure: DepartureDTO,
    @SerialName("hand_luggage")
    val handLuggage: HandLuggageDTO,
    @SerialName("has_transfer")
    val hasTransfer: Boolean,
    @SerialName("has_visa_transfer")
    val hasVisaTransfer: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("is_exchangable")
    val isExchangable: Boolean,
    @SerialName("is_returnable")
    val isReturnable: Boolean,
    @SerialName("luggage")
    val luggage: LuggageDTO,
    @SerialName("price")
    val price: PriceXDTO,
    @SerialName("provider_name")
    val providerName: String
)
