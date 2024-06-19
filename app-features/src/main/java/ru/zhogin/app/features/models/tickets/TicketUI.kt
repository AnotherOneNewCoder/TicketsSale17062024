package ru.zhogin.app.features.models.tickets


data class TicketUI(
    val arrival: ArrivalUI,
    val badge: String? = null,
    val company: String,
    val departure: DepartureUI,
    val handLuggage: HandLuggageUI,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val id: Int,
    val isExchangable: Boolean,
    val isReturnable: Boolean,
    val luggage: LuggageUI,
    val price: PriceXUI,
    val providerName: String
)