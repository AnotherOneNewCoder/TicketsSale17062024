package ru.zhogin.app_data.models.tickets


data class Ticket(
    val arrival: Arrival,
    val badge: String? = null,
    val company: String,
    val departure: Departure,
    val handLuggage: HandLuggage,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val id: Int,
    val isExchangable: Boolean,
    val isReturnable: Boolean,
    val luggage: Luggage,
    val price: PriceX,
    val providerName: String
)