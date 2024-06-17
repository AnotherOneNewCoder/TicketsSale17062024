package ru.zhogin.app_data.models.directs

import ru.zhogin.app_data.models.Price

data class TicketOffer(
    val id: Int,
    val price: Price,
    val timeRange: List<String>,
    val title: String
)
